package br.com.wildrimak.questions.data.repositories;

import br.com.wildrimak.questions.data.models.TemaJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TemaJpaRepository extends JpaRepository<TemaJPA, Integer> {

    Set<TemaJPA> findAllByDescricaoIn(Set<String> descricoes);

}
