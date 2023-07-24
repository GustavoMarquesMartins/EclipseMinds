package br.com.EclipseMinds.EclipseMinds.funcionario.controller;

import br.com.EclipseMinds.EclipseMinds.exception.NaoEncontradoException;
import br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO.DadosAtualizarFuncionario;
import br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO.DadosCadastroFuncionario;
import br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO.DadosRespostaFuncionario;
import br.com.EclipseMinds.EclipseMinds.funcionario.model.service.FuncionarioServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioServico funcionarioServico;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroFuncionario dadosCadastroFuncionario){
        funcionarioServico.cadastrar(dadosCadastroFuncionario);
    }

    @GetMapping
    public Page<DadosRespostaFuncionario> listagem(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return funcionarioServico.listar(pageable);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        funcionarioServico.deletar(id);
    }

    @PutMapping
    public DadosRespostaFuncionario atualizar(@RequestBody DadosAtualizarFuncionario dadosAtualizarFuncionario) throws NaoEncontradoException {
        return funcionarioServico.atualizar(dadosAtualizarFuncionario);
    }
}
