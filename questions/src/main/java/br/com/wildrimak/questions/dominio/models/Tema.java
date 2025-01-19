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
@EqualsAndHashCode
public class Tema {

    private Integer id;
    private String descricao;
    @Builder.Default
    private Set<Questao> questoes = new HashSet<>();

    public Set<Questao> getQuestoes() {
        return Collections.unmodifiableSet(questoes);
    }

    public void addQuestao(Questao questao) {
        this.questoes.add(questao);
    }
}