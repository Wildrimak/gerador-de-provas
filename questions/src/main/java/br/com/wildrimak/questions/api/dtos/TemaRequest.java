package br.com.wildrimak.questions.api.dtos;

import jakarta.validation.constraints.Size;

public record TemaRequest(
        @Size(max = 50)
        String descricao
) {
}
