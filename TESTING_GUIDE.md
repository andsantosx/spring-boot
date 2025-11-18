# Guia de Testes da API

Para testar os endpoints desta API de forma manual e interativa, recomendamos o uso de duas ferramentas principais:

## 1. Swagger UI (Integrado ao Projeto)

A forma mais rápida e fácil de testar a API é através da documentação interativa gerada pelo Swagger.

- **URL de Acesso:** Após iniciar a aplicação, acesse [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
- **Funcionalidades:** Você pode visualizar todos os endpoints, seus parâmetros, corpos de requisição esperados e respostas. Além disso, pode executar requisições diretamente pela interface e ver os resultados em tempo real.

## 2. Postman

Para testes mais avançados, criação de cenários complexos e automação de coleções de testes, o Postman é a ferramenta padrão da indústria.

### Passos Básicos para Testar com o Postman

1. **Inicie a Aplicação:** Garanta que o projeto esteja rodando localmente.
2. **Crie uma Requisição:**
   - Abra o Postman e crie uma nova requisição.
   - Selecione o método HTTP (GET, POST, PUT, DELETE).
   - Insira a URL do endpoint (ex: `http://localhost:8081/tecnicos`).
3. **Configure o Corpo da Requisição (para POST e PUT):**
   - Vá para a aba **Body**.
   - Selecione a opção **raw**.
   - No menu dropdown, escolha **JSON**.
   - Insira o JSON correspondente ao DTO esperado pelo endpoint.
4. **Envie e Analise:**
   - Clique em "Send".
   - Analise o **Status Code** (ex: 200, 201, 400, 404), o **Body** da resposta e os **Headers**.

Para um guia completo sobre como usar o Postman, consulte a documentação oficial:

- 🔗 **Documentação do Postman:** [https://learning.postman.com/docs/getting-started/introduction/](https://learning.postman.com/docs/getting-started/introduction/)
