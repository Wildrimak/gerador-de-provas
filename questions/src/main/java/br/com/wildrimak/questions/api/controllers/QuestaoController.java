package br.com.wildrimak.questions.api.controllers;

import br.com.wildrimak.questions.api.dtos.QuestaoRequest;
import br.com.wildrimak.questions.api.dtos.QuestaoResponse;
import br.com.wildrimak.questions.api.dtos.QuestoesRequest;
import br.com.wildrimak.questions.api.mappers.QuestaoMapper;
import br.com.wildrimak.questions.dominio.models.Questao;
import br.com.wildrimak.questions.dominio.services.QuestaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
            @RequestParam Set<String> temas,
            @RequestParam int limite,
            @RequestParam int pagina,
            @RequestParam int tamanhoPagina) {

        var questoesPaginadas = questaoService.filtrarQuestoesPorTemas(temas, limite,
                PageRequest.of(pagina, tamanhoPagina));

        var questoesResponse = questoesPaginadas.stream()
                .map(QuestaoMapper.INSTANCE::fromQuestao)
                .collect(Collectors.toList());

        return ResponseEntity.ok(questoesResponse);
    }

}
