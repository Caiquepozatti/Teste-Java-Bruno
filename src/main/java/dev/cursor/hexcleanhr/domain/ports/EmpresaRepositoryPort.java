package dev.cursor.hexcleanhr.domain.ports;

import dev.cursor.hexcleanhr.domain.model.Empresa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmpresaRepositoryPort {
    Empresa save(Empresa empresa);
    Optional<Empresa> findById(UUID id);
    List<Empresa> findAll();
    void deleteById(UUID id);
    boolean existsByCnpj(String cnpj);
}