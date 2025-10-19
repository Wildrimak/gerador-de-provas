package br.com.wildrimak.questions.dominio.repositories;

import br.com.wildrimak.questions.dominio.models.Tag;

import java.util.List;
import java.util.Set;

public interface TagRepository {

    /**
     * Dado um conjunto de tags (que podem ou não existir no banco),
     * retorna um conjunto de tags persistidos.
     * Tags que já existem são recuperados, e tags que não existem são criadas.
     *
     * @param tags O conjunto de tags a serem processados.
     * @return Um conjunto de tags gerenciados pela persistência.
     */
    Set<Tag> findOrCreateTags(Set<Tag> tags);

    List<Tag> findAll();

}
