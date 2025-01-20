package br.com.wildrimak.questions.data.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "alternativa")
public class AlternativaJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "questao_id", nullable = false)
    private QuestaoJPA questao;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "eh_a_certa", nullable = false)
    private Boolean ehACerta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public QuestaoJPA getQuestao() {
        return questao;
    }

    public void setQuestao(QuestaoJPA questao) {
        this.questao = questao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean isEhACerta() {
        return ehACerta;
    }

    public void setEhACerta(Boolean ehACerta) {
        this.ehACerta = ehACerta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlternativaJPA that = (AlternativaJPA) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getQuestao() != null ? !getQuestao().equals(that.getQuestao()) : that.getQuestao() != null) return false;
        if (!getDescricao().equals(that.getDescricao())) return false;
        return Objects.equals(ehACerta, that.ehACerta);
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getQuestao() != null ? getQuestao().hashCode() : 0);
        result = 31 * result + getDescricao().hashCode();
        result = 31 * result + (ehACerta != null ? ehACerta.hashCode() : 0);
        return result;
    }
}
