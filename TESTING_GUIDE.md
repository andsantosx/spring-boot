# Guia de Testes da API - Sistema de Serviços

Este guia descreve como testar os principais endpoints da API usando uma ferramenta como Postman ou Insomnia.

---

### Passo 1: Inicie a Aplicação

Antes de tudo, garanta que a aplicação e o banco de dados (XAMPP) estão rodando.

1.  Navegue até o diretório do projeto no terminal:
    ```sh
    cd /home/and/IdeaProjects/spring-boot/api
    ```

2.  Execute a aplicação com o Gradle Wrapper. Ela iniciará com o perfil `dev` por padrão.
    ```sh
    ./gradlew bootRun
    ```

3.  Aguarde a aplicação iniciar. Você verá no console que ela está rodando na porta **8081**.

---

### Passo 2: Teste os Endpoints

Siga esta sequência para simular um fluxo de uso real da API.

#### A. Criar um Técnico

-   **Método:** `POST`
-   **URL:** `http://localhost:8081/tecnicos`
-   **Body** (raw, JSON):

    ```json
    {
        "nome": "Valdir da Silva",
        "cpf": "123.456.789-10",
        "email": "valdir@mail.com",
        "senha": "123"
    }
    ```

-   **Resultado Esperado:** Status `201 Created`.

#### B. Criar um Cliente

-   **Método:** `POST`
-   **URL:** `http://localhost:8081/clientes`
-   **Body** (raw, JSON):

    ```json
    {
        "nome": "Linus Torvalds",
        "cpf": "987.654.321-11",
        "email": "linus@mail.com",
        "senha": "456"
    }
    ```

-   **Resultado Esperado:** Status `201 Created`.

#### C. Listar Todos os Técnicos (Verificação)

-   **Método:** `GET`
-   **URL:** `http://localhost:8081/tecnicos`

-   **Resultado Esperado:** Status `200 OK` e um array JSON contendo o técnico "Valdir da Silva".

#### D. Criar um Chamado

Vamos criar um chamado para o **Cliente (ID 2)** e atribuí-lo ao **Técnico (ID 1)**.

-   **Método:** `POST`
-   **URL:** `http://localhost:8081/chamados`
-   **Body** (raw, JSON):

    ```json
    {
        "prioridade": 2, 
        "status": 0,
        "titulo": "PC não liga",
        "observacoes": "O computador parou de funcionar após a última atualização.",
        "tecnico": 1,
        "cliente": 2
    }
    ```

-   **Resultado Esperado:** Status `201 Created`.

#### E. Listar Todos os Chamados (Verificação Final)

-   **Método:** `GET`
-   **URL:** `http://localhost:8081/chamados`

-   **Resultado Esperado:** Status `200 OK` e um array JSON com o chamado criado. Verifique se os campos `nomeTecnico` e `nomeCliente` foram preenchidos corretamente.

---

### Passo 3: Verifique o Banco de Dados

1.  Abra o **phpMyAdmin**.
2.  Acesse o banco de dados **`spring_boot`**.
3.  Verifique se as tabelas `pessoa`, `tecnico`, `cliente` e `chamado` foram criadas.
4.  Clique nas tabelas para confirmar que os dados que você enviou via API foram salvos corretamente.
