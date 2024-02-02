### ESTOQUE DE PRODUTOS

API de estoque com funcionalidade de vendas é uma plataforma de estoque que permite a gestão eficiente dos produtos e o processo de vendas.

## Tecnologias Utilizadas

- Spring Boot
- Spring Data JPA
- Banco de Dados (MySQL)
- Maven


### Banco de Dados

1. Instale o Mysql em sua máquina.
2. Crie um banco de dados chamado `estoque`.
3. Configure as propriedades do banco de dados em `src/main/resources/application.properties`.

### EndPoint

- URL: localhost:8080/estoque/cadastrar
- Método: POST
- Corpo da Requisição (JSON):

```
{
  "nome": "Nome do Produto",
  "quantidade": 10,
  "descricao": "Descrição do Produto",
  "precoUnitario": 10.00,
  "categoriaProduto": "ALIMENTOS"
}
```

