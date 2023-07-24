package br.com.EclipseMinds.EclipseMinds.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseException handleException(NaoEncontradoException naoEncontradoException) {
        return ResponseException.builder()
                .mensagem(naoEncontradoException.getMessage())
                .status(naoEncontradoException.getStatus())
                .build();
    }
}
