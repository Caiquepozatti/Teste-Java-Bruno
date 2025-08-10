package dev.cursor.hexcleanhr.infrastructure.persistence.mapper;

import dev.cursor.hexcleanhr.domain.model.Funcionario;
import dev.cursor.hexcleanhr.infrastructure.persistence.jpa.entity.FuncionarioEntity;

public class FuncionarioMapper {
    public static FuncionarioEntity toEntity(Funcionario funcionario) {
        FuncionarioEntity e = new FuncionarioEntity();
        e.setId(funcionario.getId());
        e.setNome(funcionario.getNome());
        e.setEmail(funcionario.getEmail());
        e.setDataAdmissao(funcionario.getDataAdmissao());
        e.setEmpresaId(funcionario.getEmpresaId());
        return e;
    }

    public static Funcionario toDomain(FuncionarioEntity entity) {
        return new Funcionario(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getDataAdmissao(),
                entity.getEmpresaId()
        );
    }
}