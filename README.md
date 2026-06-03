# 📚 Library Management API

Sistema de biblioteca com controle de empréstimos, devoluções e multas por atraso.

## 📋 Sobre o Projeto

API para gerenciar o acervo e os empréstimos de uma biblioteca. Controla quais livros estão disponíveis, registra empréstimos para usuários, calcula multas por atraso na devolução e atualiza automaticamente a disponibilidade do livro.

## ✨ Funcionalidades

- ✅ Cadastrar livros (título, autor, ISBN, quantidade)
- ✅ Registrar empréstimo de livro
- ✅ Registrar devolução
- ✅ Calcular multa por atraso na devolução
- ✅ Listar livros disponíveis
- ✅ Histórico de empréstimos por usuário
- ✅ Verificar se livro está disponível
- ✅ Status do empréstimo: ACTIVE, RETURNED, OVERDUE

## 🔗 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET/POST | `/api/books` | Listar / Cadastrar livros |
| GET | `/api/books/available` | Livros disponíveis |
| GET/POST | `/api/loans` | Listar / Registrar empréstimo |
| POST | `/api/loans/{id}/return` | Registrar devolução |
| GET | `/api/loans/user/{userId}` | Empréstimos por usuário |
| GET | `/api/loans/overdue` | Empréstimos em atraso |

## 🛠️ Tecnologias

- Java 17 · Spring Boot 3.2 · PostgreSQL · Maven · Lombok
