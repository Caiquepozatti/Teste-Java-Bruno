package dev.cursor.hexcleanhr.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class Funcionario {
    private UUID id;
    private String nome;
    private String email;
    private LocalDate dataAdmissao;
    private UUID empresaId;

    public Funcionario(UUID id, String nome, String email, LocalDate dataAdmissao, UUID empresaId) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataAdmissao = dataAdmissao;
        this.empresaId = empresaId;
    }

    public static Funcionario newFuncionario(String nome, String email, LocalDate dataAdmissao, UUID empresaId) {
        return new Funcionario(UUID.randomUUID(), nome, email, dataAdmissao, empresaId);
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public LocalDate getDataAdmissao() { return dataAdmissao; }
    public UUID getEmpresaId() { return empresaId; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setDataAdmissao(LocalDate dataAdmissao) { this.dataAdmissao = dataAdmissao; }
    public void setEmpresaId(UUID empresaId) { this.empresaId = empresaId; }
}