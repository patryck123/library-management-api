# Library Management API

Sistema de gestão de biblioteca com controle de acervo, empréstimos e devoluções. Gerencia disponibilidade de exemplares automaticamente e registra histórico por leitor.

## Tecnologias
Java 17 · Spring Boot 3.2 · Spring Data JPA · PostgreSQL · Maven · Swagger/OpenAPI

## Funcionalidades
- Cadastro e busca de livros por título, autor e categoria
- Controle de exemplares disponíveis por livro
- Empréstimo com prazo automático de 14 dias
- Devolução com liberação automática de exemplar
- Histórico de empréstimos por e-mail do leitor

## Como Executar
```bash
mvn spring-boot:run
# Acesse: http://localhost:8089/swagger-ui.html
```
**Patryck Martins Langsdorff** — Java Back End Developer Junior | [LinkedIn](https://www.linkedin.com/in/patryck-martins-langsdorff)
