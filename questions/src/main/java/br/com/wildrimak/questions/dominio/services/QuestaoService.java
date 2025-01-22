package br.com.wildrimak.questions.dominio.services;

import br.com.wildrimak.questions.data.mappers.QuestaoMapper;
import br.com.wildrimak.questions.data.models.QuestaoJPA;
import br.com.wildrimak.questions.data.models.TemaJPA;
import br.com.wildrimak.questions.data.repositories.QuestaoRepository;
import br.com.wildrimak.questions.data.repositories.TemaRepository;
import br.com.wildrimak.questions.dominio.models.Questao;
import br.com.wildrimak.questions.dominio.models.Tema;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.HashMap;
import java.util.Map;
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
                        .orElse(tema))
                .collect(Collectors.toSet());

        questaoJpa.setTemas(temasAjustados);

        QuestaoJPA saved = questaoRepository.save(questaoJpa);

        return QuestaoMapper.INSTANCE.toQuestao(saved);

    }

    @Transactional
    public Set<Questao> salvarQuestoes(Set<Questao> questoes) {

        var descricoesTemas = questoes.stream()
                .flatMap(questao -> questao.getTemas().stream())
                .map(Tema::getDescricao)
                .collect(Collectors.toSet());

        var temasExistentes = temaRepository.findAllByDescricaoIn(descricoesTemas);

        Map<String, TemaJPA> temasExistentesMap = temasExistentes.stream()
                .collect(Collectors.toMap(TemaJPA::getDescricao, tema -> tema));

        Map<String, TemaJPA> novosTemas = new HashMap<>();

        var questoesJPA = questoes.stream()
                .map(questao -> {
                    QuestaoJPA questaoJpa = QuestaoMapper.INSTANCE.fromQuestao(questao);

                    var temasAjustados = questaoJpa.getTemas().stream()
                            .map(tema -> {
                                String descricao = tema.getDescricao();
    
                                if (temasExistentesMap.containsKey(descricao)) {
                                    return temasExistentesMap.get(descricao);
                                }
    
                                if (novosTemas.containsKey(descricao)) {
                                    return novosTemas.get(descricao);
                                }
    
                                TemaJPA novoTema = temaRepository.save(tema);
                                novosTemas.put(descricao, novoTema);
                                return novoTema; 
                            })
                            .collect(Collectors.toSet());

                            

                    questaoJpa.setTemas(temasAjustados);
                    return questaoJpa;
                })
                .toList();

        var questoesSalvas = questaoRepository.saveAll(questoesJPA);

        return questoesSalvas.stream()
                .map(QuestaoMapper.INSTANCE::toQuestao)
                .collect(Collectors.toSet());

    }

}
