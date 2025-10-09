package br.com.wildrimak.questions.data.repositories;


import br.com.wildrimak.questions.data.models.QuestaoJPA;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestaoJpaRepository extends JpaRepository<QuestaoJPA, Integer> {

    Page<QuestaoJPA> findByTemas_DescricaoIn(Set<String> temas, Pageable novoPageable);

}
