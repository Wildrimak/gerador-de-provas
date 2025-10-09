package br.com.wildrimak.questions.data.mappers;

import br.com.wildrimak.questions.data.models.AlternativaJPA;
import br.com.wildrimak.questions.dominio.models.Alternativa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AlternativaMapper {

    @Mapping(target = "questao", ignore = true)
    Alternativa toAlternativa(AlternativaJPA alternativaJPA);

    AlternativaJPA fromAlternativa(Alternativa alternativa);

}
