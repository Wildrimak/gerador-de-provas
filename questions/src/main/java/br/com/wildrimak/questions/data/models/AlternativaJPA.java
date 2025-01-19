package br.com.wildrimak.questions.data.models;

import jakarta.persistence.*;

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
}
