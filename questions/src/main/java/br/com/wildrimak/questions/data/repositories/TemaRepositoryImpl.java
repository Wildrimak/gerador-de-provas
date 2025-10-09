package br.com.wildrimak.questions.data.repositories;

import br.com.wildrimak.questions.data.mappers.TemaMapper;
import br.com.wildrimak.questions.data.models.TemaJPA;
import br.com.wildrimak.questions.dominio.models.Tema;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class TemaRepositoryImpl implements br.com.wildrimak.questions.dominio.repositories.TemaRepository {

    private final TemaJpaRepository temaJpaRepository;

    @Override
    public Set<Tema> findOrCreateTemas(Set<Tema> temas) {

        if (temas == null || temas.isEmpty()) {
            return new HashSet<>();
        }

        var descricoes = temas.stream()
                .map(Tema::getDescricao)
                .collect(Collectors.toSet());

        var temasExistentesJPA = temaJpaRepository.findAllByDescricaoIn(descricoes);

        var temasExistentesMap = temasExistentesJPA.stream()
                .collect(Collectors.toMap(TemaJPA::getDescricao, tema -> tema));

        var temasProcessados = new HashSet<>(temasExistentesJPA);

        temas.stream()
                .filter(tema -> !temasExistentesMap.containsKey(tema.getDescricao()))
                .forEach(novoTema -> {
                    var novoTemaJPA = TemaMapper.INSTANCE.fromTema(novoTema);
                    var temaSalvo = temaJpaRepository.save(novoTemaJPA);
                    temasProcessados.add(temaSalvo);
                });

        return temasProcessados.stream()
                .map(TemaMapper.INSTANCE::toTema)
                .collect(Collectors.toSet());

    }

}
