package br.com.wildrimak.questions.data.mappers;

import br.com.wildrimak.questions.data.models.TemaJPA;
import br.com.wildrimak.questions.dominio.models.Tema;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TemaMapper {

    TemaMapper INSTANCE = Mappers.getMapper(TemaMapper.class);

    Tema toTema(TemaJPA temaJPA);

    TemaJPA fromTema(Tema tema);

}
