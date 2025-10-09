package br.com.wildrimak.questions.api.advices;

import br.com.wildrimak.questions.dominio.exceptions.EntidadeNaoEncontradaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Object> handleEntidadeNaoEncontradaException(
            EntidadeNaoEncontradaException ex,
            WebRequest request) {

        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        Erro erro = new Erro();
        erro.setStatus(status.value());
        erro.setTitle(ex.getMessage());
        erro.setDataTime(LocalDateTime.now());
        erro.setFields(List.of(
                new Erro.Field("id", "Não encontrado")
        ));

        return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);

    }

}
