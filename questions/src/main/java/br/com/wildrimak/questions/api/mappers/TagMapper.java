package br.com.wildrimak.questions.api.mappers;

import br.com.wildrimak.questions.api.dtos.TagRequest;
import br.com.wildrimak.questions.api.dtos.TagResponse;
import br.com.wildrimak.questions.dominio.models.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagMapper {

    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    TagResponse fromTag(Tag tag);

    Tag toTag(TagRequest tagRequest);

}
