package br.com.wildrimak.questions.api.mappers;

import br.com.wildrimak.questions.api.dtos.QuestaoRequest;
import br.com.wildrimak.questions.api.dtos.QuestaoResponse;
import br.com.wildrimak.questions.dominio.model.Questao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestaoMapper {

    QuestaoMapper INSTANCE = Mappers.getMapper(QuestaoMapper.class);

    @Mapping(target = "id", ignore = true)
    Questao toQuestao(QuestaoRequest questaoRequest);

    QuestaoResponse fromQuestao(Questao questao);

}
