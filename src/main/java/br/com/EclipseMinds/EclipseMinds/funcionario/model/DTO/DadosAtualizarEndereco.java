package br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAtualizarEndereco(String logradouro, String bairro, String cep, String numero, String complemento,
                                     String cidade, String uf) {
}

