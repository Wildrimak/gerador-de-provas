package br.com.wildrimak.questions.data.repositories;

import br.com.wildrimak.questions.data.mappers.QuestaoMapper;
import br.com.wildrimak.questions.data.models.TagJPA;
import br.com.wildrimak.questions.dominio.models.Questao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class QuestaoRepositoryImpl implements br.com.wildrimak.questions.dominio.repositories.QuestaoRepository {

        private final QuestaoJpaRepository questaoJpaRepository;
        private final TagJpaRepository tagJpaRepository;

    @Override
    public Questao save(Questao questao) {

        var questaoJPA = QuestaoMapper.INSTANCE.fromQuestao(questao);

        var idsTags = questaoJPA.getTags().stream()
                .map(TagJPA::getId)
                .collect(Collectors.toSet());

        var tagsGerenciados = new HashSet<>(tagJpaRepository.findAllById(idsTags));

        questaoJPA.setTags(tagsGerenciados);

        var savedQuestaoJPA = questaoJpaRepository.save(questaoJPA);

        return QuestaoMapper.INSTANCE.toQuestao(savedQuestaoJPA);

    }

    @Override
    public Set<Questao> saveAll(Set<Questao> questoes) {

        var questoesJPA = questoes.stream()
                .map(QuestaoMapper.INSTANCE::fromQuestao)
                .toList();

        var idsTags = questoesJPA.stream()
                .flatMap(q -> q.getTags().stream())
                .map(TagJPA::getId)
                .collect(Collectors.toSet());

        var tagsGerenciados = tagJpaRepository.findAllById(idsTags)
                .stream()
                .collect(Collectors.toMap(TagJPA::getId, tag -> tag));

        questoesJPA.forEach(questaoJPA ->
                questaoJPA.setTags(
                        questaoJPA.getTags().stream()
                                .map(tagJPA -> tagsGerenciados.get(tagJPA.getId()))
                                .collect(Collectors.toSet())
                )
        );

        var savedQuestoes = questaoJpaRepository.saveAll(questoesJPA);

        return savedQuestoes.stream()
                .map(QuestaoMapper.INSTANCE::toQuestao)
                .collect(Collectors.toSet());

    }

    @Override
    public List<Questao> filtrarQuestoes(Set<String> tags, String descricao, Integer nivel,
                                         Integer quantidadeDeQuestoes) {

        var page = questaoJpaRepository
                .filtrarQuestoes(
                        tags,
                        descricao,
                        nivel,
                        PageRequest.of(0, quantidadeDeQuestoes));

        return page.getContent().stream()
                .map(QuestaoMapper.INSTANCE::toQuestao)
                .collect(Collectors.toList());

    }

    @Override
    public Optional<Questao> findById(Integer id) {
        return questaoJpaRepository.findById(id).map(QuestaoMapper.INSTANCE::toQuestao);
    }

    @Override
    public boolean existsById(Integer id) {
        return questaoJpaRepository.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        questaoJpaRepository.deleteById(id);
    }

}
