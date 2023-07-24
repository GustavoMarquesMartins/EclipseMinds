package br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO;

import br.com.EclipseMinds.EclipseMinds.funcionario.model.entities.Funcionario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

public record DadosRespostaFuncionario(String nome, String telefone, BigDecimal salario, DadosEndereco endereco, Boolean status) {
    public DadosRespostaFuncionario(Funcionario funcionario) {
        this(funcionario.getNome(), funcionario.getTelefone(), funcionario.getSalario(), new DadosEndereco(funcionario.getEndereco()), funcionario.getStatus());
    }
}
