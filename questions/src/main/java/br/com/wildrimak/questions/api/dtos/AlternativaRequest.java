package br.com.wildrimak.questions.api.dtos;

import jakarta.validation.constraints.NotEmpty;

public record AlternativaRequest(
        @NotEmpty
        String descricao,
        Boolean correta
) {
}
