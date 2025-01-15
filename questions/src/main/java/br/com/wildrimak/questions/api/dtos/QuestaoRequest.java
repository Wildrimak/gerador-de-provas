package br.com.wildrimak.questions.api.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record QuestaoRequest(
        @NotEmpty @Max(25)
        String resumo,
        @NotEmpty
        String descricao,
        @Min(0) @NotNull
        Integer nivel
) {
}
