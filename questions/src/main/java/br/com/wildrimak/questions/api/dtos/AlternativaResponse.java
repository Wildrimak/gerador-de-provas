package br.com.wildrimak.questions.api.dtos;

public record AlternativaResponse(
        Integer id,
        String descricao,
        Boolean correta
) {
}
