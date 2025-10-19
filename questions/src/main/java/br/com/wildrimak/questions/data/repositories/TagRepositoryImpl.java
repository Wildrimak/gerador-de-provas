package br.com.wildrimak.questions.data.repositories;

import br.com.wildrimak.questions.data.mappers.TagMapper;
import br.com.wildrimak.questions.data.models.TagJPA;
import br.com.wildrimak.questions.dominio.models.Tag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class TagRepositoryImpl implements br.com.wildrimak.questions.dominio.repositories.TagRepository {

    private final TagJpaRepository tagJpaRepository;

    @Override
    public Set<Tag> findOrCreateTags(Set<Tag> tags) {

        if (tags == null || tags.isEmpty()) {
            return new HashSet<>();
        }

        var descricoes = tags.stream()
                .map(Tag::getDescricao)
                .collect(Collectors.toSet());

        var tagsExistentesJPA = tagJpaRepository.findAllByDescricaoIn(descricoes);

        var tagsExistentesMap = tagsExistentesJPA.stream()
                .collect(Collectors.toMap(TagJPA::getDescricao, tag -> tag));

        var tagsProcessados = new HashSet<>(tagsExistentesJPA);

        tags.stream()
                .filter(tag -> !tagsExistentesMap.containsKey(tag.getDescricao()))
                .forEach(novaTag -> {
                    var novaTagJPA = TagMapper.INSTANCE.fromTag(novaTag);
                    var tagSalvo = tagJpaRepository.save(novaTagJPA);
                    tagsProcessados.add(tagSalvo);
                });

        return tagsProcessados.stream()
                .map(TagMapper.INSTANCE::toTag)
                .collect(Collectors.toSet());

    }

    @Override
    public List<Tag> findAll() {
        return tagJpaRepository.findAll()
                .stream()
                .map(TagMapper.INSTANCE::toTag)
                .collect(Collectors.toList());
    }

}
