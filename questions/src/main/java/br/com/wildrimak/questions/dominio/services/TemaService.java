package br.com.wildrimak.questions.dominio.services;

import br.com.wildrimak.questions.dominio.models.Tema;
import br.com.wildrimak.questions.dominio.repositories.TemaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TemaService {

    private TemaRepository temaRepository;

    public List<Tema> getTemas() {
        return temaRepository.findAll();
    }

}
