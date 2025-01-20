package br.com.wildrimak.questions.api.dtos;

import java.util.Set;

public record QuestaoResponse(
        Integer id,
        String resumo,
        String descricao,
        Integer nivel,
        Set<AlternativaResponse> alternativas,
        Set<TemaResponse> temas
) {
}

