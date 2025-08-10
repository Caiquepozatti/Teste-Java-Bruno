package dev.cursor.hexcleanhr.domain.ports;

import dev.cursor.hexcleanhr.domain.model.Funcionario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FuncionarioRepositoryPort {
    Funcionario save(Funcionario funcionario);
    Optional<Funcionario> findById(UUID id);
    List<Funcionario> findAll();
    void deleteById(UUID id);
    boolean existsByEmail(String email);
    List<Funcionario> findByEmpresaId(UUID empresaId);
}