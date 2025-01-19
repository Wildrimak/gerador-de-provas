package br.com.wildrimak.questions.data.mappers;

import br.com.wildrimak.questions.data.models.AlternativaJPA;
import br.com.wildrimak.questions.dominio.models.Alternativa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlternativaMapper {

    AlternativaMapper INSTANCE = Mappers.getMapper(AlternativaMapper.class);

    Alternativa toAlternativa(AlternativaJPA alternativaJPA);

    AlternativaJPA fromAlternativa(Alternativa alternativa);

}
