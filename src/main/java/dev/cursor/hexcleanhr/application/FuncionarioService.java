package dev.cursor.hexcleanhr.application;

import dev.cursor.hexcleanhr.domain.model.Funcionario;
import dev.cursor.hexcleanhr.domain.ports.EmpresaRepositoryPort;
import dev.cursor.hexcleanhr.domain.ports.FuncionarioRepositoryPort;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class FuncionarioService {

    private final FuncionarioRepositoryPort funcionarioRepository;
    private final EmpresaRepositoryPort empresaRepository;

    public FuncionarioService(FuncionarioRepositoryPort funcionarioRepository, EmpresaRepositoryPort empresaRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.empresaRepository = empresaRepository;
    }

    public Funcionario criarFuncionario(String nome, String email, LocalDate dataAdmissao, UUID empresaId) {
        if (funcionarioRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        empresaRepository.findById(empresaId)
                .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
        return funcionarioRepository.save(Funcionario.newFuncionario(nome, email, dataAdmissao, empresaId));
    }

    public Funcionario atualizarFuncionario(UUID id, String nome, String email, LocalDate dataAdmissao, UUID empresaId) {
        Funcionario atual = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado"));
        if (!atual.getEmail().equals(email) && funcionarioRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        if (!atual.getEmpresaId().equals(empresaId)) {
            empresaRepository.findById(empresaId)
                    .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
        }
        atual.setNome(nome);
        atual.setEmail(email);
        atual.setDataAdmissao(dataAdmissao);
        atual.setEmpresaId(empresaId);
        return funcionarioRepository.save(atual);
    }

    public Funcionario buscarPorId(UUID id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado"));
    }

    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    public List<Funcionario> listarPorEmpresa(UUID empresaId) {
        return funcionarioRepository.findByEmpresaId(empresaId);
    }

    public void deletar(UUID id) {
        funcionarioRepository.deleteById(id);
    }
}