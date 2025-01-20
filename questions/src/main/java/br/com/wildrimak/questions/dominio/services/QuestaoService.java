package br.com.wildrimak.questions.dominio.services;

import br.com.wildrimak.questions.data.mappers.QuestaoMapper;
import br.com.wildrimak.questions.data.models.QuestaoJPA;
import br.com.wildrimak.questions.data.models.TemaJPA;
import br.com.wildrimak.questions.data.repositories.QuestaoRepository;
import br.com.wildrimak.questions.data.repositories.TemaRepository;
import br.com.wildrimak.questions.dominio.models.Questao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestaoService {

    private QuestaoRepository questaoRepository;
    private TemaRepository temaRepository;

    public Questao save(Questao questao) {

        var questaoJpa = QuestaoMapper.INSTANCE.fromQuestao(questao);

        Set<TemaJPA> temasAjustados = questaoJpa.getTemas().stream()
                .map(tema -> temaRepository
                        .findByDescricao(tema.getDescricao())
                        .orElse(tema)
                )
                .collect(Collectors.toSet());

        questaoJpa.setTemas(temasAjustados);

        QuestaoJPA saved = questaoRepository.save(questaoJpa);

        return QuestaoMapper.INSTANCE.toQuestao(saved);

    }

}
