package br.com.wildrimak.questions.data.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tema")
public class TemaJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String descricao;

    @ManyToMany(mappedBy = "temas")
    private List<QuestaoJPA> questoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<QuestaoJPA> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<QuestaoJPA> questoes) {
        this.questoes = questoes;
    }
}
