package br.com.wildrimak.questions.data.repositories;


import br.com.wildrimak.questions.data.models.QuestaoJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestaoRepository extends JpaRepository<QuestaoJPA, Integer> {
}
