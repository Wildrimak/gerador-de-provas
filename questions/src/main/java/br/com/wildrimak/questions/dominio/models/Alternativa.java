package br.com.wildrimak.questions.dominio.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Alternativa {

    private Integer id;
    private Questao questao;
    private String descricao;
    private boolean ehACerta;
}
