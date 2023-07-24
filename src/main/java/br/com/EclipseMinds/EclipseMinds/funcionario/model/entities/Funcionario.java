package br.com.EclipseMinds.EclipseMinds.funcionario.model.entities;

import br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO.DadosAtualizarFuncionario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "funcionarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private BigDecimal salario;

    @Column(name = "data_de_admissao")
    private LocalDateTime dataDeAdmissao = LocalDateTime.now();

    @Embedded
    private Endereco endereco;

    private Boolean status = true;

    public void statusInativo() {
        this.status = false;
    }

    public void atualizar(DadosAtualizarFuncionario dadosAtualizarFuncionario) {

        if (dadosAtualizarFuncionario.nome() != null && !dadosAtualizarFuncionario.nome().isBlank()) {
            this.nome = dadosAtualizarFuncionario.nome();
        }
        if (dadosAtualizarFuncionario.telefone() != null && !dadosAtualizarFuncionario.telefone().isBlank()) {
            this.telefone = dadosAtualizarFuncionario.telefone();
        }
        if (dadosAtualizarFuncionario.salario() != null) {
            this.salario = dadosAtualizarFuncionario.salario();
        }
        if (dadosAtualizarFuncionario.endereco() != null) {
            this.endereco.atualizar(dadosAtualizarFuncionario.endereco());
        }
    }
}
