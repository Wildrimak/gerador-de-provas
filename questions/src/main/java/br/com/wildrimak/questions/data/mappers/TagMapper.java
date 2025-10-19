package br.com.wildrimak.questions.data.mappers;

import br.com.wildrimak.questions.data.models.TagJPA;
import br.com.wildrimak.questions.dominio.models.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagMapper {

    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    @Mapping(target = "questoes", ignore = true)
    Tag toTag(TagJPA tagJPA);

    TagJPA fromTag(Tag tag);

}
