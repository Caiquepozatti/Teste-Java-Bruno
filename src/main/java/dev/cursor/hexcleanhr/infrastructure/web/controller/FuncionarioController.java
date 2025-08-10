package dev.cursor.hexcleanhr.infrastructure.web.controller;

import dev.cursor.hexcleanhr.application.FuncionarioService;
import dev.cursor.hexcleanhr.domain.model.Funcionario;
import dev.cursor.hexcleanhr.infrastructure.web.dto.FuncionarioDtos.FuncionarioRequest;
import dev.cursor.hexcleanhr.infrastructure.web.dto.FuncionarioDtos.FuncionarioResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<FuncionarioResponse> criar(@RequestBody @Valid FuncionarioRequest request) {
        Funcionario f = funcionarioService.criarFuncionario(request.nome(), request.email(), request.dataAdmissao(), request.empresaId());
        return ResponseEntity.created(URI.create("/api/funcionarios/" + f.getId()))
                .body(new FuncionarioResponse(f.getId(), f.getNome(), f.getEmail(), f.getDataAdmissao(), f.getEmpresaId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> atualizar(@PathVariable UUID id, @RequestBody @Valid FuncionarioRequest request) {
        Funcionario f = funcionarioService.atualizarFuncionario(id, request.nome(), request.email(), request.dataAdmissao(), request.empresaId());
        return ResponseEntity.ok(new FuncionarioResponse(f.getId(), f.getNome(), f.getEmail(), f.getDataAdmissao(), f.getEmpresaId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> buscar(@PathVariable UUID id) {
        Funcionario f = funcionarioService.buscarPorId(id);
        return ResponseEntity.ok(new FuncionarioResponse(f.getId(), f.getNome(), f.getEmail(), f.getDataAdmissao(), f.getEmpresaId()));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponse>> listar() {
        List<FuncionarioResponse> resposta = funcionarioService.listar().stream()
                .map(f -> new FuncionarioResponse(f.getId(), f.getNome(), f.getEmail(), f.getDataAdmissao(), f.getEmpresaId()))
                .toList();
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<List<FuncionarioResponse>> listarPorEmpresa(@PathVariable UUID empresaId) {
        List<FuncionarioResponse> resposta = funcionarioService.listarPorEmpresa(empresaId).stream()
                .map(f -> new FuncionarioResponse(f.getId(), f.getNome(), f.getEmail(), f.getDataAdmissao(), f.getEmpresaId()))
                .toList();
        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable UUID id) {
        funcionarioService.deletar(id);
    }
}