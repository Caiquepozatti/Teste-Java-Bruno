package dev.cursor.hexcleanhr.infrastructure.persistence.jpa.spring;

import dev.cursor.hexcleanhr.infrastructure.persistence.jpa.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmpresaJpaRepository extends JpaRepository<EmpresaEntity, UUID> {
    boolean existsByCnpj(String cnpj);
}