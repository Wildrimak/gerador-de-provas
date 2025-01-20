package br.com.wildrimak.questions.data.mappers;

import br.com.wildrimak.questions.data.models.TemaJPA;
import br.com.wildrimak.questions.dominio.models.Tema;
import org.mapstruct.Mapper;

@Mapper
public interface TemaMapper {

    Tema toTema(TemaJPA temaJPA);

    TemaJPA fromTema(Tema tema);

}
