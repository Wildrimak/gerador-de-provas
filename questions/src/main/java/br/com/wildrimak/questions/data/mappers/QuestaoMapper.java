package br.com.wildrimak.questions.data.mappers;

import br.com.wildrimak.questions.data.models.AlternativaJPA;
import br.com.wildrimak.questions.data.models.QuestaoJPA;
import br.com.wildrimak.questions.data.models.TagJPA;
import br.com.wildrimak.questions.dominio.models.Alternativa;
import br.com.wildrimak.questions.dominio.models.Questao;
import br.com.wildrimak.questions.dominio.models.Tag;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;

@Mapper(uses = {AlternativaMapper.class, TagMapper.class})
public interface QuestaoMapper {

    QuestaoMapper INSTANCE = Mappers.getMapper(QuestaoMapper.class);

    @Mapping(target = "alternativas", ignore = true)
    @Mapping(target = "tags", ignore = true)
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
    default void mapTags(@MappingTarget Questao questao, QuestaoJPA questaoJPA) {
        Set<Tag> tags = new HashSet<>();
        for (TagJPA tagJPA : questaoJPA.getTags()) {
            Tag tag = Tag
                .builder()
                .id(tagJPA.getId())
                .descricao(tagJPA.getDescricao())
                .build();
            tag.addQuestao(questao);
            tags.add(tag);
        }
        questao.setTags(tags);
    }

}
