package dev.cursor.hexcleanhr.domain.model;

import java.util.UUID;

public class Empresa {
    private UUID id;
    private String nome;
    private String cnpj;

    public Empresa(UUID id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public static Empresa newEmpresa(String nome, String cnpj) {
        return new Empresa(UUID.randomUUID(), nome, cnpj);
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}