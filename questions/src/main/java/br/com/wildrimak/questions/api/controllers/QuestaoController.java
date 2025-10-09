package br.com.wildrimak.questions.api.controllers;

import br.com.wildrimak.questions.api.dtos.QuestaoRequest;
import br.com.wildrimak.questions.api.dtos.QuestaoResponse;
import br.com.wildrimak.questions.api.dtos.QuestoesRequest;
import br.com.wildrimak.questions.api.mappers.QuestaoMapper;
import br.com.wildrimak.questions.dominio.models.Questao;
import br.com.wildrimak.questions.dominio.services.QuestaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questoes")
@AllArgsConstructor
public class QuestaoController {

    private final QuestaoService questaoService;

    @PostMapping
    public ResponseEntity<QuestaoResponse> postQuestao(@RequestBody @Valid QuestaoRequest questaoRequest) {

        var questao = QuestaoMapper.INSTANCE.toQuestao(questaoRequest);

        Questao saved = questaoService.save(questao);

        var location = UriComponentsBuilder.fromPath("/questoes/{id}").buildAndExpand(saved.getId()).toUri();

        var questaoResponse = QuestaoMapper.INSTANCE.fromQuestao(saved);

        return ResponseEntity.created(location).body(questaoResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestaoResponse> putQuestao(
            @PathVariable Integer id,
            @RequestBody @Valid QuestaoRequest questaoRequest) {

        var questaoParaAtualizar = QuestaoMapper.INSTANCE.toQuestao(questaoRequest);
        var questaoAtualizada = questaoService.atualizarQuestao(id, questaoParaAtualizar);
        var questaoResponse = QuestaoMapper.INSTANCE.fromQuestao(questaoAtualizada);

        return ResponseEntity.ok(questaoResponse);

    }

    @PostMapping("/lote")
    public ResponseEntity<List<QuestaoResponse>> postQuestoes(@RequestBody @Valid QuestoesRequest questoesRequest) {

        var questoes = QuestaoMapper.INSTANCE.fromQuestoesRequest(questoesRequest);

        var questoesSalvas = questaoService.salvarQuestoes(questoes);

        var questoesResponse = questoesSalvas
                .stream()
                .map(questao -> QuestaoMapper.INSTANCE.fromQuestao(questao))
                .collect(Collectors.toList());

        return ResponseEntity.ok(questoesResponse);

    }

    @GetMapping
    public ResponseEntity<List<QuestaoResponse>> getQuestoes(
            @RequestParam(required = false) Set<String> temas,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) Integer nivel,
            @RequestParam(required = false) Integer quantidadeDeQuestoes) {

        var questoes = questaoService.filtrarQuestoes(temas, descricao, nivel, quantidadeDeQuestoes);

        var questoesResponse = questoes.stream()
                .map(QuestaoMapper.INSTANCE::fromQuestao)
                .collect(Collectors.toList());

        return ResponseEntity.ok(questoesResponse);
    }

}
