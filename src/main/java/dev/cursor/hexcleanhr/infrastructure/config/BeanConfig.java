package dev.cursor.hexcleanhr.infrastructure.config;

import dev.cursor.hexcleanhr.application.EmpresaService;
import dev.cursor.hexcleanhr.application.FuncionarioService;
import dev.cursor.hexcleanhr.domain.ports.EmpresaRepositoryPort;
import dev.cursor.hexcleanhr.domain.ports.FuncionarioRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public EmpresaService empresaService(EmpresaRepositoryPort empresaRepositoryPort) {
        return new EmpresaService(empresaRepositoryPort);
    }

    @Bean
    public FuncionarioService funcionarioService(FuncionarioRepositoryPort funcionarioRepositoryPort, EmpresaRepositoryPort empresaRepositoryPort) {
        return new FuncionarioService(funcionarioRepositoryPort, empresaRepositoryPort);
    }
}