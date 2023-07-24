package br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosCadastroFuncionario(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotNull
        BigDecimal salario,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
