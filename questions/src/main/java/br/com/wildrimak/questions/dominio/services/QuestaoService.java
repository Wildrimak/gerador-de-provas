package br.com.wildrimak.questions.dominio.services;

import br.com.wildrimak.questions.data.mappers.QuestaoMapper;
import br.com.wildrimak.questions.data.models.QuestaoJPA;
import br.com.wildrimak.questions.data.repositories.QuestaoRepository;
import br.com.wildrimak.questions.dominio.models.Questao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestaoService {

    private QuestaoRepository questaoRepository;

    public Questao save(Questao questao) {

        var questaoJpa = QuestaoMapper.INSTANCE.fromQuestao(questao);
        QuestaoJPA saved = questaoRepository.save(questaoJpa);

        return QuestaoMapper.INSTANCE.toQuestao(saved);

    }

}
