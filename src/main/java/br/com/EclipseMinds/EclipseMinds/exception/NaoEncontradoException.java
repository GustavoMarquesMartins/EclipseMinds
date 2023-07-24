package br.com.EclipseMinds.EclipseMinds.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Data
public class NaoEncontradoException extends BaseDadosException {
    private final HttpStatus status = HttpStatus.BAD_REQUEST;
    private String mensagem;
    public NaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
