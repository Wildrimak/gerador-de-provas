package br.com.wildrimak.questions.api.controllers;

import br.com.wildrimak.questions.api.dtos.TemaResponse;
import br.com.wildrimak.questions.api.mappers.TemaMapper;
import br.com.wildrimak.questions.dominio.services.TemaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/temas")
@AllArgsConstructor
public class TemaController {

    private final TemaService temaService;

    @GetMapping
    public ResponseEntity<List<TemaResponse>> getTemas() {

        var temas = temaService.getTemas();

        var temasResponse = temas.stream()
                .map(TemaMapper.INSTANCE::fromTema)
                .collect(Collectors.toList());

        return ResponseEntity.ok(temasResponse);

    }

}
