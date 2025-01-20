package br.com.wildrimak.questions.data.mappers;

import br.com.wildrimak.questions.data.models.AlternativaJPA;
import br.com.wildrimak.questions.dominio.models.Alternativa;
import org.mapstruct.Mapper;

@Mapper
public interface AlternativaMapper {

    Alternativa toAlternativa(AlternativaJPA alternativaJPA);

    AlternativaJPA fromAlternativa(Alternativa alternativa);

}
