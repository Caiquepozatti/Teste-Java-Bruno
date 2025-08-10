package dev.cursor.hexcleanhr.infrastructure.persistence.jpa.spring;

import dev.cursor.hexcleanhr.infrastructure.persistence.jpa.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FuncionarioJpaRepository extends JpaRepository<FuncionarioEntity, UUID> {
    boolean existsByEmail(String email);
    List<FuncionarioEntity> findByEmpresaId(UUID empresaId);
}