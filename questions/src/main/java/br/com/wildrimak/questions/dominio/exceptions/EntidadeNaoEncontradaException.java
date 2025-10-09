package br.com.wildrimak.questions.dominio.exceptions;

public class EntidadeNaoEncontradaException extends RuntimeException {

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }

}