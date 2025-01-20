package br.com.wildrimak.questions.data.mappers;

import br.com.wildrimak.questions.data.models.AlternativaJPA;
import br.com.wildrimak.questions.data.models.QuestaoJPA;
import br.com.wildrimak.questions.data.models.TemaJPA;
import br.com.wildrimak.questions.dominio.models.Alternativa;
import br.com.wildrimak.questions.dominio.models.Questao;
import br.com.wildrimak.questions.dominio.models.Tema;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;

@Mapper(uses = {AlternativaMapper.class, TemaMapper.class})
public interface QuestaoMapper {

    QuestaoMapper INSTANCE = Mappers.getMapper(QuestaoMapper.class);

    @Mapping(target = "alternativas", ignore = true)
    @Mapping(target = "temas", ignore = true)
    Questao toQuestao(QuestaoJPA questaoJPA);

    @Mapping(target = "alternativas", ignore = true)
    QuestaoJPA fromQuestao(Questao questao);

    @AfterMapping
    default void mapAlternativas(@MappingTarget QuestaoJPA questaoJPA, Questao questao) {
        Set<AlternativaJPA> alternativasJPA = new HashSet<>();
        for (Alternativa alternativa : questao.getAlternativas()) {
            AlternativaJPA alternativaJPA = new AlternativaJPA();
            alternativaJPA.setQuestao(questaoJPA);
            alternativaJPA.setDescricao(alternativa.getDescricao());
            alternativaJPA.setEhACerta(alternativa.getEhACerta());
            alternativasJPA.add(alternativaJPA);
        }
        questaoJPA.setAlternativas(alternativasJPA);
    }

    @AfterMapping
    default void mapAlternativas(@MappingTarget Questao questao, QuestaoJPA questaoJPA) {
        Set<Alternativa> alternativas = new HashSet<>();
        for (AlternativaJPA alternativaJPA : questaoJPA.getAlternativas()) {
            Alternativa alternativa = Alternativa
                    .builder()
                    .id(alternativaJPA.getId())
                    .questao(questao)
                    .descricao(alternativaJPA.getDescricao())
                    .ehACerta(alternativaJPA.isEhACerta())
                    .build();
            alternativas.add(alternativa);
        }
        questao.setAlternativas(alternativas);
    }

    @AfterMapping
    default void mapTemas(@MappingTarget Questao questao, QuestaoJPA questaoJPA) {
        Set<Tema> temas = new HashSet<>();
        for (TemaJPA temaJPA : questaoJPA.getTemas()) {
            Tema tema = Tema
                    .builder()
                    .id(temaJPA.getId())
                    .descricao(temaJPA.getDescricao())
                    .build();
            tema.addQuestao(questao);
            temas.add(tema);
        }
        questao.setTemas(temas);
    }

}
