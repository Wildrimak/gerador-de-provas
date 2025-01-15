package br.com.wildrimak.questions.data.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questao")
public class QuestaoJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 25)
    private String resumo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "nivel_dificuldade", nullable = false)
    private int nivelDificuldade;

    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlternativaJPA> alternativas = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "tema_questao",
            joinColumns = @JoinColumn(name = "id_questao"),
            inverseJoinColumns = @JoinColumn(name = "id_tema")
    )
    private List<TemaJPA> temas = new ArrayList<>();

    public void setAlternativas(List<AlternativaJPA> alternativas) {
        this.alternativas = alternativas;
    }

    public List<AlternativaJPA> getAlternativas() {
        return alternativas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(int nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }

    public List<TemaJPA> getTemas() {
        return temas;
    }

    public void setTemas(List<TemaJPA> temas) {
        this.temas = temas;
    }
}
