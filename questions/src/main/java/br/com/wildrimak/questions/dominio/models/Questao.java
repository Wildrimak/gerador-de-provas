package br.com.wildrimak.questions.dominio.models;

import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Questao {

    @EqualsAndHashCode.Include
    private Integer id;

    @EqualsAndHashCode.Include
    private String descricao;

    @EqualsAndHashCode.Include
    private Integer nivelDificuldade;

    @Builder.Default
    @Setter(AccessLevel.NONE)
    private Set<Alternativa> alternativas = new HashSet<>();

    @Builder.Default
    private Set<Tema> temas = new HashSet<>();

    public Set<Alternativa> getAlternativas() {
        return Collections.unmodifiableSet(alternativas);
    }

    public void setAlternativas(Set<Alternativa> novasAlternativas) {

        this.alternativas.forEach(alternativa -> alternativa.setQuestao(null));

        if (novasAlternativas == null || novasAlternativas.isEmpty()) {
            this.alternativas = new HashSet<>();
            return;
        }

        var countCorretas = novasAlternativas.stream()
                .filter(Alternativa::getEhACerta)
                .count();

        if (countCorretas != 1) {
            throw new IllegalStateException("Uma questão deve ter exatamente uma alternativa correta " +
                    "ou não possuir alternativas, mas foram encontradas " + countCorretas + " alternativas corretas");
        }

        novasAlternativas.forEach(alternativa -> alternativa.setQuestao(this));
        this.alternativas = novasAlternativas;

    }

    public Set<Tema> getTemas() {
        return Collections.unmodifiableSet(temas);
    }

}