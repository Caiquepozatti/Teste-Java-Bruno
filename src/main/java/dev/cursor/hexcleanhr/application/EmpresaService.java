package dev.cursor.hexcleanhr.application;

import dev.cursor.hexcleanhr.domain.model.Empresa;
import dev.cursor.hexcleanhr.domain.ports.EmpresaRepositoryPort;

import java.util.List;
import java.util.UUID;

public class EmpresaService {

    private final EmpresaRepositoryPort empresaRepository;

    public EmpresaService(EmpresaRepositoryPort empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa criarEmpresa(String nome, String cnpj) {
        if (empresaRepository.existsByCnpj(cnpj)) {
            throw new IllegalArgumentException("CNPJ já cadastrado");
        }
        return empresaRepository.save(Empresa.newEmpresa(nome, cnpj));
    }

    public Empresa atualizarEmpresa(UUID id, String nome, String cnpj) {
        Empresa atual = empresaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
        if (!atual.getCnpj().equals(cnpj) && empresaRepository.existsByCnpj(cnpj)) {
            throw new IllegalArgumentException("CNPJ já cadastrado");
        }
        atual.setNome(nome);
        atual.setCnpj(cnpj);
        return empresaRepository.save(atual);
    }

    public Empresa buscarPorId(UUID id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
    }

    public List<Empresa> listar() {
        return empresaRepository.findAll();
    }

    public void deletar(UUID id) {
        empresaRepository.deleteById(id);
    }
}