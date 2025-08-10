# Hex Clean HR

Projeto exemplo de CRUD para domínios Empresa e Funcionario com Arquitetura Hexagonal + Clean Architecture, usando Spring Boot 3 e H2.

## Requisitos
- Java 21+
- Maven (`mvn`)

## Rodando
```bash
mvn spring-boot:run
```

H2 Console: http://localhost:8080/h2-console

## Estrutura (simplificada)
- domain: entidades e portas de serviço
- application: casos de uso
- infrastructure: adaptações (persistence, web)