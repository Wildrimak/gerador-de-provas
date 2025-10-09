package br.com.wildrimak.questions.dominio.services;

import br.com.wildrimak.questions.dominio.models.Questao;
import br.com.wildrimak.questions.dominio.models.Tema;
import br.com.wildrimak.questions.dominio.repositories.QuestaoRepository;
import br.com.wildrimak.questions.dominio.repositories.TemaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestaoService {

    private QuestaoRepository questaoRepository;
    private TemaRepository temaRepository;

    public Questao save(Questao questao) {

        var temasPersistidos = temaRepository.findOrCreateTemas(questao.getTemas());
        questao.setTemas(temasPersistidos);

        return questaoRepository.save(questao);

    }

    @Transactional
    public Set<Questao> salvarQuestoes(Set<Questao> questoes) {

        var temasParaProcessar = questoes.stream()
                .flatMap(questao -> questao.getTemas().stream())
                .collect(Collectors.toSet());

        var temasPersistidos = temaRepository.findOrCreateTemas(temasParaProcessar);

        var temasPersistidosMap = temasPersistidos.stream()
                .collect(Collectors.toMap(Tema::getDescricao, tema -> tema));

        questoes.forEach(questao -> {

            var temasAtualizados = questao.getTemas().stream()
                    .map(tema -> temasPersistidosMap.get(tema.getDescricao()))
                    .collect(Collectors.toSet());

            questao.setTemas(temasAtualizados);

        });

        return questaoRepository.saveAll(questoes);

    }

    public List<Questao> filtrarQuestoesPorTemas(Set<String> temas, int limite, Pageable pageable) {

        var tamanhoPagina = Math.min(pageable.getPageSize(), limite);
        Pageable novoPageable = PageRequest.of(pageable.getPageNumber(), tamanhoPagina, pageable.getSort());

        return questaoRepository.findByTemaDescriptions(temas, novoPageable);

    }

}
