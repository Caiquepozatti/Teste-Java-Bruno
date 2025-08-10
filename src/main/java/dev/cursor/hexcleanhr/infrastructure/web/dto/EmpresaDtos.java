package dev.cursor.hexcleanhr.infrastructure.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class EmpresaDtos {

    public record EmpresaRequest(
            @NotBlank String nome,
            @NotBlank @Size(min = 14, max = 18) String cnpj
    ) {}

    public record EmpresaResponse(
            UUID id,
            String nome,
            String cnpj
    ) {}
}