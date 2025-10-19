package br.com.wildrimak.questions.api.controllers;

import br.com.wildrimak.questions.api.dtos.TagResponse;
import br.com.wildrimak.questions.api.mappers.TagMapper;
import br.com.wildrimak.questions.dominio.services.TagService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tags")
@AllArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping
    public ResponseEntity<List<TagResponse>> getTags() {

        var tags = tagService.getTags();

        var tagsResponse = tags.stream()
                .map(TagMapper.INSTANCE::fromTag)
                .collect(Collectors.toList());

        return ResponseEntity.ok(tagsResponse);

    }

}
