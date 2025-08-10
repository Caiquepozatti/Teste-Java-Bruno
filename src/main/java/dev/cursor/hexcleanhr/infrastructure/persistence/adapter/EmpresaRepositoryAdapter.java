package dev.cursor.hexcleanhr.infrastructure.persistence.adapter;

import dev.cursor.hexcleanhr.domain.model.Empresa;
import dev.cursor.hexcleanhr.domain.ports.EmpresaRepositoryPort;
import dev.cursor.hexcleanhr.infrastructure.persistence.jpa.entity.EmpresaEntity;
import dev.cursor.hexcleanhr.infrastructure.persistence.jpa.spring.EmpresaJpaRepository;
import dev.cursor.hexcleanhr.infrastructure.persistence.mapper.EmpresaMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class EmpresaRepositoryAdapter implements EmpresaRepositoryPort {

    private final EmpresaJpaRepository jpaRepository;

    public EmpresaRepositoryAdapter(EmpresaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Empresa save(Empresa empresa) {
        EmpresaEntity saved = jpaRepository.save(EmpresaMapper.toEntity(empresa));
        return EmpresaMapper.toDomain(saved);
    }

    @Override
    public Optional<Empresa> findById(UUID id) {
        return jpaRepository.findById(id).map(EmpresaMapper::toDomain);
    }

    @Override
    public List<Empresa> findAll() {
        return jpaRepository.findAll().stream().map(EmpresaMapper::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByCnpj(String cnpj) {
        return jpaRepository.existsByCnpj(cnpj);
    }
}