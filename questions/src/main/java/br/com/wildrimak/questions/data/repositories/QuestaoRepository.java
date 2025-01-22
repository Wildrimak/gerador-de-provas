package br.com.wildrimak.questions.data.repositories;


import br.com.wildrimak.questions.data.models.QuestaoJPA;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestaoRepository extends JpaRepository<QuestaoJPA, Integer> {

    Page<QuestaoJPA> findByTemasDescricao(String tema, Pageable novoPageable);

}
