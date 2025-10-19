package br.com.wildrimak.questions.data.repositories;


import br.com.wildrimak.questions.data.models.QuestaoJPA;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestaoJpaRepository extends JpaRepository<QuestaoJPA, Integer> {

    @Query("SELECT q FROM QuestaoJPA q JOIN q.tags t " +
            "WHERE (:tags IS NULL OR t.descricao IN :tags) " +
            "AND (:descricao IS NULL OR LOWER(q.descricao) LIKE LOWER(CONCAT('%', CAST(:descricao AS string), '%'))) " +
            "AND (:nivelDificuldade IS NULL OR q.nivelDificuldade = :nivelDificuldade)")
    Page<QuestaoJPA> filtrarQuestoes(
            @Param("tags") Set<String> tags,
            @Param("descricao") String descricao,
            @Param("nivelDificuldade") Integer nivelDificuldade,
            Pageable pageable);

}
