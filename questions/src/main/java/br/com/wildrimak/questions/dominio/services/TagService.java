package br.com.wildrimak.questions.dominio.services;

import br.com.wildrimak.questions.dominio.models.Tag;
import br.com.wildrimak.questions.dominio.repositories.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagService {

    private TagRepository tagRepository;

    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

}
