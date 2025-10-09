package br.com.wildrimak.questions.dominio.repositories;

import br.com.wildrimak.questions.dominio.models.Tema;

import java.util.List;
import java.util.Set;

public interface TemaRepository {

    /**
     * Dado um conjunto de temas (que podem ou não existir no banco),
     * retorna um conjunto de temas persistidos.
     * Temas que já existem são recuperados, e temas que não existem são criados.
     *
     * @param temas O conjunto de temas a serem processados.
     * @return Um conjunto de temas gerenciados pela persistência.
     */
    Set<Tema> findOrCreateTemas(Set<Tema> temas);

    List<Tema> findAll();

}
