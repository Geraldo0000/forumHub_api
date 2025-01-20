# Fórum Hub API

Este projeto é uma API RESTful desenvolvida para gerenciar tópicos e discussões em um fórum. Foi criada como parte do desafio promovido pela **Alura** em parceria com o programa **Oracle Next Education**.

---

## 📚 Tecnologias Utilizadas

- **Linguagem**: Java 21
- **Framework**: Spring Boot 3
- **Banco de Dados**: MySQL (migração gerenciada com Flyway)
- **Gerenciamento de Dependências**: Maven
- **Validação e Segurança**: Spring Validation e Spring Security
- **Autenticação**: JWT (JSON Web Token)
- **Documentação**: Springdoc OpenAPI

---

## 🧩 Dependências

A configuração completa das dependências está disponível no arquivo `pom.xml`. Aqui estão as principais:

- **Spring Boot Starter Web**: Desenvolvimento de APIs REST.
- **Spring Boot Starter Data JPA**: Manipulação de dados no banco de dados.
- **Spring Boot Starter Validation**: Validações de dados de entrada.
- **Spring Boot Starter Security**: Autenticação e autorização.
- **Flyway**: Migração e versionamento do banco de dados.
- **Lombok**: Redução de código boilerplate.
- **Springdoc OpenAPI**: Geração automática da documentação interativa da API.
- **MySQL Connector**: Integração com o banco de dados MySQL.

---

## ✨ Funcionalidades

- **Cadastro de Tópicos**  
  Permite registrar novos tópicos, garantindo a unicidade do título e da mensagem.

- **Listagem de Tópicos**  
  Lista os tópicos cadastrados no sistema, com suporte a **paginação** e **ordenação**.

- **Detalhamento de Tópico**  
  Exibe informações detalhadas de um tópico por meio do seu ID.

- **Atualização e Exclusão de Tópicos**
    - Atualiza informações de tópicos já cadastrados.
    - Realiza exclusões lógicas, marcando os tópicos como inativos.

- **Autenticação com JWT**  
  Garante que apenas usuários autenticados possam acessar os endpoints protegidos.

---

## 🚀 Como Executar o Projeto

**Clone o repositório**:
   ```bash
   git clone https://github.com/forumHub_api/forum-hub-api.git
