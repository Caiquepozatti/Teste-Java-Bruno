package dev.cursor.hexcleanhr.infrastructure.web.controller;

import dev.cursor.hexcleanhr.application.EmpresaService;
import dev.cursor.hexcleanhr.domain.model.Empresa;
import dev.cursor.hexcleanhr.infrastructure.web.dto.EmpresaDtos.EmpresaRequest;
import dev.cursor.hexcleanhr.infrastructure.web.dto.EmpresaDtos.EmpresaResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<EmpresaResponse> criar(@RequestBody @Valid EmpresaRequest request) {
        Empresa e = empresaService.criarEmpresa(request.nome(), request.cnpj());
        return ResponseEntity.created(URI.create("/api/empresas/" + e.getId()))
                .body(new EmpresaResponse(e.getId(), e.getNome(), e.getCnpj()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaResponse> atualizar(@PathVariable UUID id, @RequestBody @Valid EmpresaRequest request) {
        Empresa e = empresaService.atualizarEmpresa(id, request.nome(), request.cnpj());
        return ResponseEntity.ok(new EmpresaResponse(e.getId(), e.getNome(), e.getCnpj()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponse> buscar(@PathVariable UUID id) {
        Empresa e = empresaService.buscarPorId(id);
        return ResponseEntity.ok(new EmpresaResponse(e.getId(), e.getNome(), e.getCnpj()));
    }

    @GetMapping
    public ResponseEntity<List<EmpresaResponse>> listar() {
        List<EmpresaResponse> resposta = empresaService.listar().stream()
                .map(e -> new EmpresaResponse(e.getId(), e.getNome(), e.getCnpj()))
                .toList();
        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable UUID id) {
        empresaService.deletar(id);
    }
}