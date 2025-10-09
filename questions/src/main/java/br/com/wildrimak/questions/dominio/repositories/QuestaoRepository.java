package br.com.wildrimak.questions.dominio.repositories;

import br.com.wildrimak.questions.dominio.models.Questao;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface QuestaoRepository {

    Questao save(Questao questao);

    Set<Questao> saveAll(Set<Questao> questoes);

    List<Questao> findByTemaDescriptions(Set<String> temas, Pageable pageable);

}
