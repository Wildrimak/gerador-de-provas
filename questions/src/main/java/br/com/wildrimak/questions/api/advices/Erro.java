package br.com.wildrimak.questions.api.advices;

import java.time.LocalDateTime;
import java.util.List;

public class Erro {

    private Integer status;
    private LocalDateTime dataTime;
    private String title;
    private List<Field> fields;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dataTime = dataTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public static class Field {

        private String name;
        private String message;

        public Field(String name, String message) {
            super();
            this.name = name;
            this.message = message;
        }

        public String getNome() {
            return name;
        }

        public void setNome(String nome) {
            this.name = nome;
        }

        public String getMensagem() {
            return message;
        }

        public void setMensagem(String mensagem) {
            this.message = mensagem;
        }

    }

}
