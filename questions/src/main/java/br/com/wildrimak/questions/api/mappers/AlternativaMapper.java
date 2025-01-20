package br.com.wildrimak.questions.api.mappers;

import br.com.wildrimak.questions.api.dtos.AlternativaResponse;
import br.com.wildrimak.questions.dominio.models.Alternativa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AlternativaMapper {

    @Mapping(target = "correta", source = "ehACerta")
    AlternativaResponse fromAlternativa(Alternativa alternativa);
}
