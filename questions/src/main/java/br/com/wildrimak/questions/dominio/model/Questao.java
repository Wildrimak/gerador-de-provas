package br.com.wildrimak.questions.dominio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Questao {

    private Integer id;
    private String resumo;
    private String descricao;
    private Integer nivel;

}
