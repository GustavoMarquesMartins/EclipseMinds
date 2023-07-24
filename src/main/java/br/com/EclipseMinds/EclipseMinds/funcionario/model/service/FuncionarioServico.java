package br.com.EclipseMinds.EclipseMinds.funcionario.model.service;

import br.com.EclipseMinds.EclipseMinds.exception.NaoEncontradoException;
import br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO.DadosAtualizarFuncionario;
import br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO.DadosCadastroFuncionario;
import br.com.EclipseMinds.EclipseMinds.funcionario.model.DTO.DadosRespostaFuncionario;
import br.com.EclipseMinds.EclipseMinds.funcionario.model.entities.Funcionario;
import br.com.EclipseMinds.EclipseMinds.funcionario.model.repository.FuncionarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioServico {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    ModelMapper modelMapper;

    public void cadastrar(DadosCadastroFuncionario dadosCadastroFuncionario) {
        funcionarioRepository.save(modelMapper.map(dadosCadastroFuncionario, Funcionario.class));
    }

    public Page<DadosRespostaFuncionario> listar(Pageable pageable) {
        return funcionarioRepository.findAll(pageable).map(DadosRespostaFuncionario::new);
    }

    @Transactional
    public void deletar(Long id) {
        var funcionario = funcionarioRepository.getReferenceById(id);
        funcionario.statusInativo();
    }

    @Transactional
    public DadosRespostaFuncionario atualizar(DadosAtualizarFuncionario dadosAtualizarFuncionario) throws NaoEncontradoException {
        var funcionario = validarFuncionarioExistente(dadosAtualizarFuncionario.id());
        funcionario.atualizar(dadosAtualizarFuncionario);
        return new DadosRespostaFuncionario(funcionario);
    }

    public Funcionario validarFuncionarioExistente(Long id) throws NaoEncontradoException {
        return funcionarioRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Funcionario não encontrado"));
    }
}
