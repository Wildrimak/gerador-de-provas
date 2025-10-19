package br.com.wildrimak.questions.data.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tag")
public class TagJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50, unique = true)
    private String descricao;

    @ManyToMany(mappedBy = "tags")
    private Set<QuestaoJPA> questoes = new HashSet<>();

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

    public Set<QuestaoJPA> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(Set<QuestaoJPA> questoes) {
        this.questoes = questoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagJPA tagJPA = (TagJPA) o;

        if (getId() != null ? !getId().equals(tagJPA.getId()) : tagJPA.getId() != null) return false;
        return getDescricao() != null ? getDescricao().equals(tagJPA.getDescricao()) : tagJPA.getDescricao() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDescricao() != null ? getDescricao().hashCode() : 0);
        return result;
    }

}
