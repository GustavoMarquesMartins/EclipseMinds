package br.com.EclipseMinds.EclipseMinds.funcionario.model.repository;

import br.com.EclipseMinds.EclipseMinds.funcionario.model.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
