package br.com.wildrimak.questions.data.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "questao")
public class QuestaoJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "nivel_dificuldade")
    private Integer nivelDificuldade;

    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AlternativaJPA> alternativas = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tema_questao",
            joinColumns = @JoinColumn(name = "id_questao"),
            inverseJoinColumns = @JoinColumn(name = "id_tema")
    )
    private Set<TemaJPA> temas = new HashSet<>();

    public void setAlternativas(Set<AlternativaJPA> alternativas) {
        this.alternativas = alternativas;
    }

    public Set<AlternativaJPA> getAlternativas() {
        return alternativas;
    }

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

    public Integer getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(Integer nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }

    public Set<TemaJPA> getTemas() {
        return temas;
    }

    public void setTemas(Set<TemaJPA> temas) {
        this.temas = temas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestaoJPA that = (QuestaoJPA) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (!getDescricao().equals(that.getDescricao())) return false;
        return getNivelDificuldade() != null ? getNivelDificuldade().equals(that.getNivelDificuldade()) : that.getNivelDificuldade() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getDescricao().hashCode();
        result = 31 * result + (getNivelDificuldade() != null ? getNivelDificuldade().hashCode() : 0);
        return result;
    }
}
