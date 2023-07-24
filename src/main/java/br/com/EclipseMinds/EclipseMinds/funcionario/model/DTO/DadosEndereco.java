package br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO;

import br.com.EclipseMinds.EclipseMinds.funcionario.model.entities.Endereco;
import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        String cep,
        @NotBlank
        String numero,
        String complemento,
        @NotBlank
        String cidade,
        @NotBlank
        String uf) {
    public DadosEndereco(Endereco endereco) {
        this(endereco.getLogradouro(), endereco.getBairro(), endereco.getCep(), endereco.getNumero(),
                endereco.getComplemento(), endereco.getCidade(), endereco.getUf());
    }
}
