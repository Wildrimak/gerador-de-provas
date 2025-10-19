package br.com.wildrimak.questions.data.repositories;

import br.com.wildrimak.questions.data.models.TagJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TagJpaRepository extends JpaRepository<TagJPA, Integer> {

    Set<TagJPA> findAllByDescricaoIn(Set<String> descricoes);

}
