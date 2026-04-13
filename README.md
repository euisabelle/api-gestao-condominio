# API de Gestão de Condomínios (PropTech)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/springboot-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2-%23F37626.svg?style=for-the-badge&logo=h2&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05032.svg?style=for-the-badge&logo=git&logoColor=white)

## Sobre o Projeto
Este projeto é uma **API RESTful** desenvolvida para otimizar e digitalizar a administração de condomínios. A aplicação resolve problemas reais do dia a dia de síndicos e administradoras de imóveis, permitindo o gerenciamento de moradores e a organização inteligente das reservas de áreas comuns.

O sistema foi desenhado com foco em **regras de negócio**, garantindo, por exemplo, que não ocorram conflitos de agendamento no mesmo espaço físico, promovendo uma melhor convivência coletiva (conceito central em empresas de gestão imobiliária e PropTechs).

## Tecnologias e Padrões Utilizados
O projeto foi construído alinhado com as práticas:
- **Java 17+** e **Spring Boot 3** (Spring Web, Spring Data JPA).
- **Arquitetura em Camadas (MVC):** Separação clara da lógica de domínio entre `Model`, `Repository`, `Service` e `Controller`.
- **Banco de Dados Relacional:** H2 em memória para testes ágeis (com estrutura 100% pronta para migração Oracle/PostgreSQL).
- **Documentação Interativa:** Integração com Swagger/OpenAPI para testes fáceis e visuais de todos os endpoints.
- **Controle de Versão:** Git e GitHub.

## Funcionalidades e Regras de Negócio Implementadas
- **CRUD Completo de Moradores:** Rotas para Cadastro (POST), Listagem (GET), Atualização (PUT) e Remoção (DELETE) de moradores na base de dados.
- **Sistema Relacional de Reservas:** Agendamento de áreas comuns (ex: Churrasqueira, Salão de Festas) vinculado diretamente ao ID do morador cadastrado (utilizando relacionamento `@ManyToOne` no banco de dados).
- **Validação Anti-Conflito:** Camada de serviço inteligente (`ReservaService`) que bloqueia a transação e retorna erro caso um espaço selecionado já esteja reservado para a mesma data.

## Como rodar o projeto localmente

1. Clone este repositório no seu terminal utilizando o comando:
    git clone https://github.com/euisabelle/api-gestao-condominio.git

2. Abra a pasta do projeto na sua IDE favorita (recomendado: IntelliJ IDEA).
3. Aguarde o Maven baixar as dependências e execute a classe principal `GestaoCondominioApplication.java`.
4. A API estará rodando perfeitamente na porta local `8080`.

## Como testar as rotas da API (Swagger)
Com o projeto rodando, acesse a interface visual gerada automaticamente pelo Swagger através do seu navegador:
> **http://localhost:8080/swagger-ui.html**

## Roadmap e Próximos Passos
- [ ] Implementar a interface web para os moradores utilizando JSF / PrimeFaces.
- [ ] Migrar o banco de dados principal de H2 para **Oracle** utilizando Stored Procedures em PL/SQL.
- [ ] Adicionar testes unitários com JUnit e Mockito.
- [ ] Configurar um pipeline de integração contínua (CI/CD) com GitHub Actions.

---
Desenvolvido por **Isabelle Melo**
[(LinkedIn)](https://www.linkedin.com/in/isabellemelo)
