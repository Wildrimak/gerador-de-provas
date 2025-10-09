package br.com.wildrimak.questions.data.repositories;

import br.com.wildrimak.questions.data.mappers.QuestaoMapper;
import br.com.wildrimak.questions.data.models.TemaJPA;
import br.com.wildrimak.questions.dominio.models.Questao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class QuestaoRepositoryImpl implements br.com.wildrimak.questions.dominio.repositories.QuestaoRepository {

    private final QuestaoJpaRepository questaoJpaRepository;
    private final TemaJpaRepository temaJpaRepository;

    @Override
    public Questao save(Questao questao) {

        var questaoJPA = QuestaoMapper.INSTANCE.fromQuestao(questao);

        var idsTemas = questaoJPA.getTemas().stream()
                .map(TemaJPA::getId)
                .collect(Collectors.toSet());

        var temasGerenciados = new HashSet<>(temaJpaRepository.findAllById(idsTemas));

        questaoJPA.setTemas(temasGerenciados);

        var savedQuestaoJPA = questaoJpaRepository.save(questaoJPA);

        return QuestaoMapper.INSTANCE.toQuestao(savedQuestaoJPA);

    }

    @Override
    public Set<Questao> saveAll(Set<Questao> questoes) {

        var questoesJPA = questoes.stream()
                .map(QuestaoMapper.INSTANCE::fromQuestao)
                .toList();

        var idsTemas = questoesJPA.stream()
                .flatMap(q -> q.getTemas().stream())
                .map(TemaJPA::getId)
                .collect(Collectors.toSet());

        var temasGerenciados = temaJpaRepository.findAllById(idsTemas)
                .stream()
                .collect(Collectors.toMap(TemaJPA::getId, tema -> tema));

        questoesJPA.forEach(questaoJPA ->
                questaoJPA.setTemas(
                        questaoJPA.getTemas().stream()
                                .map(temaJPA -> temasGerenciados.get(temaJPA.getId()))
                                .collect(Collectors.toSet())
                )
        );

        var savedQuestoes = questaoJpaRepository.saveAll(questoesJPA);

        return savedQuestoes.stream()
                .map(QuestaoMapper.INSTANCE::toQuestao)
                .collect(Collectors.toSet());

    }

    @Override
    public List<Questao> filtrarQuestoes(Set<String> temas, String descricao, Integer nivel,
                                         Integer quantidadeDeQuestoes) {

        var page = questaoJpaRepository
                .filtrarQuestoes(
                        temas,
                        descricao,
                        nivel,
                        PageRequest.of(0, quantidadeDeQuestoes));

        return page.getContent().stream()
                .map(QuestaoMapper.INSTANCE::toQuestao)
                .collect(Collectors.toList());

    }

}
