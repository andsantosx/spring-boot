Sistema de Gestão de Serviços - API REST com Spring Boot

Este projeto é uma API RESTful completa para um sistema de gestão de chamados (ordens de serviço), desenvolvida com Java 21 e Spring Boot 3. O objetivo principal é demonstrar, de forma prática, os conceitos fundamentais e as melhores práticas na construção de APIs modernas.
✨ Conceitos e Funcionalidades

Esta API implementa um CRUD completo para as seguintes entidades:

    Técnicos: Responsáveis por atender aos chamados.
    Clientes: Solicitantes dos chamados.
    Chamados: Ordens de serviço que conectam um cliente a um técnico.

Durante seu desenvolvimento, foram aplicados os seguintes conceitos:

    Arquitetura em Camadas: Separação clara de responsabilidades entre Controllers (Recursos), Services (Lógica de Negócio) e Repositories (Acesso a Dados).
    Herança com JPA: A classe Pessoa serve como base para Tecnico e Cliente, utilizando a estratégia InheritanceType.JOINED.
    Relacionamentos JPA: Uso de @ManyToOne e @OneToMany para criar a ligação entre Chamados, Técnicos e Clientes.
    Padrão DTO (Data Transfer Object): Utilização de DTOs para desacoplar a camada da API do modelo de domínio, garantindo segurança e flexibilidade.
    Validações: Uso de jakarta.validation (@Valid) para garantir a integridade dos dados recebidos pela API.
    Tratamento de Exceções Centralizado: Um @ControllerAdvice (ResourceExceptionHandler) captura exceções da aplicação e retorna respostas de erro HTTP padronizadas e informativas.
    Spring Profiles: Configuração de ambientes distintos para desenvolvimento, produção e testes (application-dev.properties, etc.), permitindo diferentes configurações de banco de dados e comportamento da aplicação.
    Documentação de API com Swagger: Geração automática de uma documentação interativa da API com SpringDoc OpenAPI.

🛠️ Tecnologias Utilizadas

    Java 21
    Spring Boot 3
    Spring Data JPA (com Hibernate)
    Spring Web
    Gradle (Gerenciador de Dependências)
    Banco de Dados: MySQL (para dev/prod) e H2 (para testes)
    MapStruct: Para conversão automática entre Entidades e DTOs (configurado no build.gradle).
    SpringDoc OpenAPI: Para documentação da API (Swagger UI).

🚀 Como Executar o Projeto

Siga os passos abaixo para configurar e executar a aplicação em seu ambiente local.
1. Pré-requisitos

    Java 21 (JDK) instalado.
    Um servidor de banco de dados MySQL ou MariaDB em execução (ex: XAMPP, Docker).

2. Configuração do Banco de Dados

A aplicação está configurada para se conectar a um banco de dados local. Crie um banco de dados no seu servidor MySQL/MariaDB com o seguinte comando:

CREATE DATABASE spring_boot CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

Observação: As tabelas (pessoa, tecnico, chamado, etc.) serão criadas ou atualizadas automaticamente pelo Hibernate na primeira vez que a aplicação for iniciada, graças à configuração spring.jpa.hibernate.ddl-auto=update.
3. Executando a Aplicação

    Abra um terminal e navegue até a raiz do projeto:

    cd /caminho/para/o/projeto/api

    Execute o comando do Gradle Wrapper para iniciar a aplicação:

    ./gradlew bootRun

    A aplicação iniciará com o perfil de desenvolvimento (dev) por padrão, rodando na porta 8081 e conectando-se ao banco de dados spring_boot.

📖 Como Usar a API

Após iniciar a aplicação, você pode interagir com ela de duas maneiras principais.
1. Documentação Interativa (Swagger UI)

A forma mais fácil de explorar e testar os endpoints é através da interface do Swagger.

    Acesse a URL no seu navegador: http://localhost:8081/api-docs

Lá, você encontrará uma lista de todos os endpoints disponíveis, com detalhes sobre os parâmetros necessários e a possibilidade de testá-los diretamente.
2. Guia de Testes com Postman/Insomnia

Para um passo a passo guiado sobre como testar o fluxo completo da API (criar um técnico, um cliente e depois um chamado para eles), consulte o arquivo:

    TESTING_GUIDE.md

Este guia detalha as requisições POST e GET necessárias para verificar se toda a funcionalidade está operando corretamente.
🔒 Segurança

O arquivo .gitignore foi configurado para ignorar todos os arquivos application-*.properties. Isso é uma medida de segurança crucial para evitar que senhas de banco de dados e outras informações sensíveis sejam enviadas para o repositório Git.

Ao clonar o projeto, um desenvolvedor deve criar seus próprios arquivos de propriedades a partir de um template (não incluído neste projeto, mas uma prática recomendada).
