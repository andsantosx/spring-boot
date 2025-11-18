# API de Gerenciamento de Chamados

API RESTful desenvolvida com Spring Boot para gerenciar chamados de suporte técnico, associando clientes e técnicos. O projeto segue as melhores práticas de arquitetura de software, incluindo separação de responsabilidades, uso de DTOs, validação em camadas e tratamento de exceções padronizado.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**: Versão mais recente da linguagem Java.
- **Spring Boot 3.3.0**: Framework principal para a construção da aplicação.
- **Spring Data JPA**: Para persistência de dados e comunicação com o banco.
- **Maven**: Gerenciador de dependências e build do projeto.
- **MySQL**: Banco de dados relacional para armazenamento dos dados.
- **H2 Database**: Banco de dados em memória para os testes.
- **MapStruct**: Geração automática de código para mapeamento entre DTOs e Entidades.
- **Springdoc (Swagger)**: Geração automática de documentação interativa para a API.
- **Bean Validation**: Para validação dos dados de entrada na camada de DTOs.

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos

- **Java 21 (JDK)** instalado.
- **Maven** instalado.
- Um servidor **MySQL** rodando localmente (ou em um container Docker).
- Um banco de dados chamado `spring_boot` criado no seu servidor MySQL.

### Passos para Execução

1. **Clone o repositório:**
   ```sh
   git clone <url-do-seu-repositorio>
   ```

2. **Navegue até a pasta raiz do projeto:**
   ```sh
   cd spring-boot
   ```

3. **Configure o banco de dados:**
   - Abra o arquivo `src/main/resources/application-dev.properties`.
   - Altere as propriedades `spring.datasource.username` e `spring.datasource.password` com as suas credenciais do MySQL.

4. **Execute a aplicação com o Maven:**
   ```sh
   mvn spring-boot:run
   ```

A aplicação estará disponível em `http://localhost:8081`.

---

## 📚 Documentação da API (Swagger)

Após iniciar a aplicação, a documentação completa e interativa da API estará disponível no Swagger UI. Você pode usar esta interface para visualizar e testar todos os endpoints.

- **URL do Swagger UI:** [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

---

## Endpoints Disponíveis

A API expõe recursos para gerenciar Técnicos, Clientes e Chamados.

- `GET /tecnicos` - Lista todos os técnicos.
- `GET /tecnicos/{id}` - Busca um técnico por ID.
- `POST /tecnicos` - Cria um novo técnico.
- `PUT /tecnicos/{id}` - Atualiza um técnico existente.
- `DELETE /tecnicos/{id}` - Remove um técnico.

- `GET /clientes` - Lista todos os clientes.
- `GET /clientes/{id}` - Busca um cliente por ID.
- `POST /clientes` - Cria um novo cliente.
- `PUT /clientes/{id}` - Atualiza um cliente existente.
- `DELETE /clientes/{id}` - Remove um cliente.

- `GET /chamados` - Lista todos os chamados.
- `GET /chamados/{id}` - Busca um chamado por ID.
- `POST /chamados` - Cria um novo chamado.
- `PUT /chamados/{id}` - Atualiza um chamado existente.
