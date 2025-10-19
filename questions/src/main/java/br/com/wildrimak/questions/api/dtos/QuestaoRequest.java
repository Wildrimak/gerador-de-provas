package br.com.wildrimak.questions.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.util.HashSet;
import java.util.Set;

public record QuestaoRequest(

        @NotEmpty
        String descricao,

        @Min(0)
        Integer nivel,

        @Valid
        Set<AlternativaRequest> alternativas,

        Set<TagRequest> tags
) {
    public QuestaoRequest(String descricao, Integer nivel, Set<AlternativaRequest> alternativas,
                          Set<TagRequest> tags) {
        this.descricao = descricao;
        this.nivel = nivel;
        this.alternativas = alternativas == null ? new HashSet<>() : alternativas;
        this.tags = tags == null ? new HashSet<>() : tags;
    }
}

