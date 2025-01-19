package br.com.wildrimak.questions.api.controllers;

import br.com.wildrimak.questions.api.dtos.QuestaoRequest;
import br.com.wildrimak.questions.api.dtos.QuestaoResponse;
import br.com.wildrimak.questions.api.mappers.QuestaoMapper;
import br.com.wildrimak.questions.dominio.models.Questao;
import br.com.wildrimak.questions.dominio.services.QuestaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/questoes")
@AllArgsConstructor
public class QuestaoController {

    private QuestaoService questaoService;

    @PostMapping
    public ResponseEntity<QuestaoResponse> postQuestao(@RequestBody @Valid QuestaoRequest questaoRequest) {

        var questao = QuestaoMapper.INSTANCE.toQuestao(questaoRequest);

        Questao saved = questaoService.save(questao);

        var location = UriComponentsBuilder.fromPath("/questoes/{id}").buildAndExpand(saved.getId()).toUri();

        var questaoResponse = QuestaoMapper.INSTANCE.fromQuestao(saved);

        return ResponseEntity.created(location).body(questaoResponse);

    }

}
