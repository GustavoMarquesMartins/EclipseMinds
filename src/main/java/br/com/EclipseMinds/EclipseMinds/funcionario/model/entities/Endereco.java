package br.com.EclipseMinds.EclipseMinds.funcionario.model.entities;

import br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO.DadosAtualizarEndereco;
import br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO.DadosAtualizarFuncionario;
import br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public void atualizar(DadosAtualizarEndereco dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
    }
}
