# Hex Clean HR

Projeto exemplo de CRUD para domínios Empresa e Funcionario com Arquitetura Hexagonal + Clean Architecture, usando Spring Boot 3.

## Requisitos
- Java 21+
- Maven (`mvn`) ou Maven Wrapper (`./mvnw`)

## Rodando (H2 em memória - padrão)
```bash
./mvnw spring-boot:run
```

H2 Console: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:hrdb`)

## Rodando com PostgreSQL
1) Suba um Postgres local com Docker (opcional):
```bash
docker compose up -d
```
2) Execute a aplicação com o profile `postgres`:
```bash
DB_HOST=localhost \
DB_PORT=5432 \
DB_NAME=hrdb \
DB_USER=hr \
DB_PASSWORD=hr \
./mvnw spring-boot:run -Dspring-boot.run.profiles=postgres
```

## Estrutura (simplificada)
- domain: entidades e portas de serviço
- application: casos de uso
- infrastructure: adaptações (persistence, web)