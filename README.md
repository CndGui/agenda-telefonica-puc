# Agenda Telefônica

Trabalho de faculdade: um CRUD simples de contatos (cadastrar, listar, buscar, atualizar e remover).

## Tecnologias

- **Java** (Maven)
- **PostgreSQL**

## Banco de dados

O dump do PostgreSQL está em `database/phone_book_dump.sql`.

Para restaurar:

```bash
psql -U postgres -d agenda < database/phone_book_dump.sql
```

## Como rodar

```bash
mvn compile
mvn exec:java
```
