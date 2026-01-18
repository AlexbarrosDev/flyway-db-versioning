# Flyway DB Versioning Study

Projeto simples de **To-Do List**, criado **exclusivamente para fins de estudo**, 
com foco em **versionamento de banco de dados** utilizando **Flyway** em conjunto com **Spring Boot** e **PostgreSQL**.

---

## Objetivo do Projeto

- Praticar versionamento de banco de dados com Flyway
- Entender o fluxo de migrations (`V1`, `V2`, `V3`, ...)
- Integrar Flyway com Spring Boot
- Trabalhar com alterações de schema sem depender do `ddl-auto` do Hibernate
- Manter histórico e rastreabilidade das mudanças no banco

> ⚠️ **Este projeto não tem foco em regras de negócio complexas, tratamento avançado de exceções ou segurança.**

---

## 🛠️ Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Flyway
- PostgreSQL
- Maven

---

## Estrutura do Projeto

```text
src/
├── main
│   ├── java
│   │   └── com
│   │       └── alexdev
│   │           ├── controllers
│   │           │   └── TaskController.java
│   │           ├── dtos
│   │           │   └── response
│   │           │       └── TaskDTO.java
│   │           ├── entities
│   │           │   └── Task.java
│   │           ├── enums
│   │           │   └── TaskStatus.java
│   │           ├── mappers
│   │           │   └── TaskMapper.java
│   │           ├── repositories
│   │           │   └── TaskRepository.java
│   │           ├── services
│   │           │   └── TaskService.java
│   │           └── StartupApplication.java
│   └── resources
│       ├── application.yaml
│       └── db
│           └── migration
│               ├── V1__create_table_task.sql
│               ├── V2__alter_table_task.sql
│               └── V3__alter_table_moment_timezone.sql
└── test
    └── java
        └── com
            └── alexdev
                └── StartupApplicationTests.java

```

---

## Migrations

As migrations seguem o padrão do Flyway:

- `V1__create_table_task.sql`
- `V2__alter_table_task.sql`
- `V3__...`

Cada alteração estrutural no banco é feita **exclusivamente via migration**, garantindo:

- Histórico de mudanças
- Reprodutibilidade
- Controle de versão do banco

---

## Configuração

O projeto utiliza:

- `hibernate.ddl-auto=validate`
- Flyway habilitado para validação e execução das migrations

Isso garante que:
- O Hibernate **não altera** a estrutura do banco
- O schema esteja sempre alinhado com as migrations

---

## Como executar

1. Criar um banco PostgreSQL
2. Ajustar as configurações de conexão no `application.yaml`
3. Executar a aplicação
4. O Flyway aplicará automaticamente as migrations

---

## Observações Finais

- Projeto voltado **apenas para estudo e prática técnica**
- Estrutura simples e objetiva
- Ideal para demonstrar conhecimento em **Flyway + Spring Boot**

---

## Autor

**Autor:** Alex Barros
- Buri - SP
- Estudante de ADS / Desenvolvedor Back-End Java

## Contato

- LinkedIn: [Alex Barros](https://www.linkedin.com/in/alex-barros-dev)
- Email: alexbarros.dev@gmail.com
