package br.com.wildrimak.questions.dominio.services;

import br.com.wildrimak.questions.dominio.models.Questao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestaoService {

//    private QuestaoRepository questaoRepository;

    public Questao save(Questao questao) {
        questao.setId(1);
        return questao;
    }

}
