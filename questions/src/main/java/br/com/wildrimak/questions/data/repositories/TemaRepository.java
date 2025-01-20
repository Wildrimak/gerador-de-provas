package br.com.wildrimak.questions.data.repositories;

import br.com.wildrimak.questions.data.models.TemaJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TemaRepository extends JpaRepository<TemaJPA, Integer> {

    Optional<TemaJPA> findByDescricao(String descricao);

}
