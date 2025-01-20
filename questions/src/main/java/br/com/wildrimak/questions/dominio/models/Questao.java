package br.com.wildrimak.questions.dominio.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
    private String resumo;

    @EqualsAndHashCode.Include
    private String descricao;

    @EqualsAndHashCode.Include
    private Integer nivelDificuldade;

    @Builder.Default
    private Set<Alternativa> alternativas = new HashSet<>();

    @Builder.Default
    private Set<Tema> temas = new HashSet<>();

    public void addAlternativa(Alternativa alternativa) {
        alternativas.add(alternativa);
        alternativa.setQuestao(this);
    }

    public void removeAlternativa(Alternativa alternativa) {
        alternativas.remove(alternativa);
        alternativa.setQuestao(null);
    }

    public void addTema(Tema tema) {
        temas.add(tema);
        tema.getQuestoes().add(this);
    }

    public void removeTema(Tema tema) {
        temas.remove(tema);
        tema.getQuestoes().remove(this);
    }

    public Set<Alternativa> getAlternativas() {
        return Collections.unmodifiableSet(alternativas);
    }

    public Set<Tema> getTemas() {
        return Collections.unmodifiableSet(temas);
    }

}