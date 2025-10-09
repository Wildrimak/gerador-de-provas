package br.com.wildrimak.questions.dominio.repositories;

import br.com.wildrimak.questions.dominio.models.Questao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface QuestaoRepository {

    Questao save(Questao questao);

    Set<Questao> saveAll(Set<Questao> questoes);

    List<Questao> filtrarQuestoes(Set<String> temas, String descricao, Integer nivel, Integer quantidadeDeQuestoes);

    Optional<Questao> findById(Integer id);

    boolean existsById(Integer id);

    void deleteById(Integer id);

}
