package dev.cursor.hexcleanhr.infrastructure.persistence.mapper;

import dev.cursor.hexcleanhr.domain.model.Empresa;
import dev.cursor.hexcleanhr.infrastructure.persistence.jpa.entity.EmpresaEntity;

public class EmpresaMapper {
    public static EmpresaEntity toEntity(Empresa empresa) {
        EmpresaEntity e = new EmpresaEntity();
        e.setId(empresa.getId());
        e.setNome(empresa.getNome());
        e.setCnpj(empresa.getCnpj());
        return e;
    }

    public static Empresa toDomain(EmpresaEntity entity) {
        return new Empresa(entity.getId(), entity.getNome(), entity.getCnpj());
    }
}