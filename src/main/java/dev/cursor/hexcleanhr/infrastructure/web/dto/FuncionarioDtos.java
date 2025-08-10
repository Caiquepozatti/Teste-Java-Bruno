package dev.cursor.hexcleanhr.infrastructure.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public class FuncionarioDtos {

    public record FuncionarioRequest(
            @NotBlank String nome,
            @NotBlank @Email String email,
            @NotNull LocalDate dataAdmissao,
            @NotNull UUID empresaId
    ) {}

    public record FuncionarioResponse(
            UUID id,
            String nome,
            String email,
            LocalDate dataAdmissao,
            UUID empresaId
    ) {}
}