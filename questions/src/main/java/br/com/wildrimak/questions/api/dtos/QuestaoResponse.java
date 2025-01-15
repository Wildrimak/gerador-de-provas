package br.com.wildrimak.questions.api.dtos;

public record QuestaoResponse(
        Integer id,
        String resumo,
        String descricao,
        Integer nivel
) {
}

