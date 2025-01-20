package br.com.wildrimak.questions.api.mappers;

import br.com.wildrimak.questions.api.dtos.AlternativaRequest;
import br.com.wildrimak.questions.api.dtos.QuestaoRequest;
import br.com.wildrimak.questions.api.dtos.QuestaoResponse;
import br.com.wildrimak.questions.dominio.models.Alternativa;
import br.com.wildrimak.questions.dominio.models.Questao;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Mapper(uses = AlternativaMapper.class)
public interface QuestaoMapper {

    QuestaoMapper INSTANCE = Mappers.getMapper(QuestaoMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "alternativas", ignore = true)
    @Mapping(target = "nivelDificuldade", source = "nivel")
    Questao toQuestao(QuestaoRequest questaoRequest);

    @Mapping(target = "nivel", source = "nivelDificuldade")
    QuestaoResponse fromQuestao(Questao questao);

    default Set<Alternativa> mapAlternativas(Set<AlternativaRequest> alternativaRequests, @MappingTarget Questao questao) {
        if (alternativaRequests == null || alternativaRequests.isEmpty()) {
            return Collections.emptySet();
        }

        Set<Alternativa> alternativas = new HashSet<>();
        for (AlternativaRequest alternativaRequest : alternativaRequests) {
            Alternativa alternativa = Alternativa.builder()
                    .descricao(alternativaRequest.descricao())
                    .ehACerta(alternativaRequest.correta())
                    .questao(questao)
                    .build();
            alternativas.add(alternativa);
        }
        return alternativas;
    }

    @AfterMapping
    default void configureRelationships(@MappingTarget Questao questao, QuestaoRequest questaoRequest) {
        questao.setAlternativas(mapAlternativas(questaoRequest.alternativas(), questao));
    }

}
