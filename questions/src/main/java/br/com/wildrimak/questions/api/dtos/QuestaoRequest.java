package br.com.wildrimak.questions.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

public record QuestaoRequest(

        @Size(max = 25)
        String resumo,

        @NotEmpty
        String descricao,

        @Min(0)
        Integer nivel,

        @Valid
        Set<AlternativaRequest> alternativas,

        Set<TemaRequest> temas
) {
        public QuestaoRequest(String resumo, String descricao, Integer nivel, Set<AlternativaRequest> alternativas, Set<TemaRequest> temas) {
                this.resumo = resumo;
                this.descricao = descricao;
                this.nivel = nivel;
                this.alternativas = alternativas == null ? new HashSet<>() : alternativas;
                this.temas = temas == null ? new HashSet<>() : temas;
        }
}

