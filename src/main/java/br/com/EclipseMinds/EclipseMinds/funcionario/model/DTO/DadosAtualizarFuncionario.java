package br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAtualizarFuncionario(
        @NotNull
        Long id,
        String nome,
        String telefone,
        BigDecimal salario,
        DadosAtualizarEndereco endereco) {
}
