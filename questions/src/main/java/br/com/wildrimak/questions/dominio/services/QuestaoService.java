package br.com.wildrimak.questions.dominio.services;

import br.com.wildrimak.questions.dominio.exceptions.EntidadeNaoEncontradaException;
import br.com.wildrimak.questions.dominio.models.Questao;
import br.com.wildrimak.questions.dominio.models.Tag;
import br.com.wildrimak.questions.dominio.repositories.QuestaoRepository;
import br.com.wildrimak.questions.dominio.repositories.TagRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestaoService {

    private QuestaoRepository questaoRepository;
    private TagRepository tagRepository;

    public Questao save(Questao questao) {

        var tagsPersistidos = tagRepository.findOrCreateTags(questao.getTags());
        questao.setTags(tagsPersistidos);

        return questaoRepository.save(questao);

    }

    @Transactional
    public Set<Questao> salvarQuestoes(Set<Questao> questoes) {

        var tagsParaProcessar = questoes.stream()
            .flatMap(questao -> questao.getTags().stream())
            .collect(Collectors.toSet());

        var tagsPersistidos = tagRepository.findOrCreateTags(tagsParaProcessar);

        var tagsPersistidosMap = tagsPersistidos.stream()
            .collect(Collectors.toMap(Tag::getDescricao, tag -> tag));

        questoes.forEach(questao -> {

            var tagsAtualizados = questao.getTags().stream()
                .map(tag -> tagsPersistidosMap.get(tag.getDescricao()))
                .collect(Collectors.toSet());

            questao.setTags(tagsAtualizados);

        });

        return questaoRepository.saveAll(questoes);

    }

    public List<Questao> filtrarQuestoes(Set<String> tags, String descricao, Integer nivel,
                                         Integer quantidadeDeQuestoes) {

        int limiteFinal = (quantidadeDeQuestoes != null) ? quantidadeDeQuestoes : 10000;
        return questaoRepository.filtrarQuestoes(tags, descricao, nivel, limiteFinal);

    }

    @Transactional
    public Questao atualizarQuestao(Integer id, Questao questaoComNovosDados) {

        var questaoAtual = questaoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Questão não encontrada com id: " + id));

        questaoAtual.setDescricao(questaoComNovosDados.getDescricao());
        questaoAtual.setNivelDificuldade(questaoComNovosDados.getNivelDificuldade());
        questaoAtual.setAlternativas(questaoComNovosDados.getAlternativas());

        var tagsPersistidos = tagRepository.findOrCreateTags(questaoComNovosDados.getTags());
        questaoAtual.setTags(tagsPersistidos);

        return questaoRepository.save(questaoAtual);
        
    }

    public void deletarQuestao(Integer id) {

        if (questaoRepository.existsById(id)) {
            questaoRepository.deleteById(id);
            return;
        }

        throw new EntidadeNaoEncontradaException("Questão com o ID " + id + " não encontrada.");

    }

}
