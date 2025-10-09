package br.com.wildrimak.questions.api.mappers;

import br.com.wildrimak.questions.api.dtos.TemaResponse;
import br.com.wildrimak.questions.dominio.models.Tema;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TemaMapper {

    TemaMapper INSTANCE = Mappers.getMapper(TemaMapper.class);

    TemaResponse fromTema(Tema tema);

}
