package br.com.wildrimak.questions.api.dtos;

import java.util.List;

import jakarta.validation.Valid;

public record QuestoesRequest(
    @Valid
    List<QuestaoRequest> questoes
) { 
    
}
