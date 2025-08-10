package dev.cursor.hexcleanhr.infrastructure.persistence.adapter;

import dev.cursor.hexcleanhr.domain.model.Funcionario;
import dev.cursor.hexcleanhr.domain.ports.FuncionarioRepositoryPort;
import dev.cursor.hexcleanhr.infrastructure.persistence.jpa.entity.FuncionarioEntity;
import dev.cursor.hexcleanhr.infrastructure.persistence.jpa.spring.FuncionarioJpaRepository;
import dev.cursor.hexcleanhr.infrastructure.persistence.mapper.FuncionarioMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class FuncionarioRepositoryAdapter implements FuncionarioRepositoryPort {

    private final FuncionarioJpaRepository jpaRepository;

    public FuncionarioRepositoryAdapter(FuncionarioJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        FuncionarioEntity saved = jpaRepository.save(FuncionarioMapper.toEntity(funcionario));
        return FuncionarioMapper.toDomain(saved);
    }

    @Override
    public Optional<Funcionario> findById(UUID id) {
        return jpaRepository.findById(id).map(FuncionarioMapper::toDomain);
    }

    @Override
    public List<Funcionario> findAll() {
        return jpaRepository.findAll().stream().map(FuncionarioMapper::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }

    @Override
    public List<Funcionario> findByEmpresaId(UUID empresaId) {
        return jpaRepository.findByEmpresaId(empresaId).stream().map(FuncionarioMapper::toDomain).toList();
    }
}