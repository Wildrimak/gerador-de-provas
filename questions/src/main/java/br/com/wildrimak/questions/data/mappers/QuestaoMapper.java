package br.com.wildrimak.questions.data.mappers;

import br.com.wildrimak.questions.data.models.QuestaoJPA;
import br.com.wildrimak.questions.dominio.models.Questao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestaoMapper {

    QuestaoMapper INSTANCE = Mappers.getMapper(QuestaoMapper.class);

    Questao toQuestao(QuestaoJPA questaoJPA);

    QuestaoJPA fromQuestao(Questao questao);

}
