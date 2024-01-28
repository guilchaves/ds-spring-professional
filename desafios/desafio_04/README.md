#  DESAFIO: Consulta vendas

## Java Spring Professional


### Desafio
Trata-se de um sistema de vendas (Sale) e vendedores (Seller). Cada venda está para um vendedor, e um
vendedor pode ter várias vendas. </br>
Você deverá implementas as seguintes consultas:

##### Relatório de vendas
1. [IN] O usuário informa, opcionalmente, data inicial, data final e um trecho do nome do vendedor.</br>
2. [OUT] O sistema informa uma listagem paginada contendo id, data, quantia vendida e nome do
   vendedor, das vendas que se enquadrem nos dados informados.</br>

Informações complementares:</br>
-  Se a data final não for informada, considerar a data atual do sistema. Para instanciar a data atual,
utilize o comando:</br>
```
    LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
```
- Se a data inicial não for informada, considerar a data de 1 ano antes da data final. Para instanciar
uma data com um ano a menos, use a função minusYears:</br>
```
    LocalDate result = minhaData.minusYears(1L);
```
-  Se o nome não for informado, considerar o texto vazio.</br>
-  Dica: receba todos os dados como String no controller, e faça os tratamentos das datas acima,
instanciando os objetos LocalDate, no service.</br>

##### Sumário de vendas por vendedor

1. [IN] O usuário informa, opcionalmente, data inicial, data final.</br>
2. [OUT] O sistema informa uma listagem contendo nome do vendedor e soma de vendas deste vendedor
   no período informado.</br>

Informações complementares:</br>
- As mesmas do caso de uso Relatório de vendas


**Seu projeto deverá fazer um seed de pelo menos 10 clientes** com dados SIGNIFICATIVOS (não é para
usar dados sem significado como “Nome 1”, “Nome 2”, etc.).</br>

**Seu projeto deverá tratar as seguintes exceções:**
- Id não encontrado (para GET por id, PUT e DELETE), retornando código 404.</br>
- Erro de validação, retornando código 422 e mensagens customizada para cada campo inválido. As
  regras de validação são: </br>
    - Nome: não pode ser vazio
    - Data de nascimento: não pode ser data futura (dica: use @PastOrPresent)

### Testes manuais de Endpoints
#### Sumário de vendas por vendedor (teste 1)
  - _GET /sales/summary?minDate=2022-01-01&maxDate=2022-06-30_</br>
###### Deverá retornar o sumário de vendas por vendedor no período informado
```json
[
  {
    "sellerName": "Anakin",
    "total": 110571.0
  },
  {
    "sellerName": "Logan",
    "total": 83587.0
  },
  {
    "sellerName": "Loki Odinson",
    "total": 150597.0
  },
  {
    "sellerName": "Padme",
    "total": 135902.0
  },
  {
    "sellerName": "Thor Odinson",
    "total": 144896.0
  }
]
```
#### Sumário de vendas por vendedor (teste 2)
  - _GET /sales/summary
######  Deverá retornar o sumário de vendas por vendedor dos últimos 12 meses.

#### Relatório de vendas (teste 3)
- _GET /sales/report_
###### Deverá retornar o relatório de vendas dos últimos 12 meses.

#### Relatório de vendas (teste 4)
- _GET /sales/report?minDate=2022-05-01&maxDate=2022-05-31&name=odinson_
###### Deverá retornar o relatório de vendas do período/vendedor informados

```json
{
  "content": [
    {
      "id": 9,
      "date": "2022-05-22",
      "amount": 19476.0,
      "sellerName": "Loki Odinson"
    },
    {
      "id": 10,
      "date": "2022-05-18",
      "amount": 20530.0,
      "sellerName": "Thor Odinson"
    },
    {
      "id": 12,
      "date": "2022-05-06",
      "amount": 21753.0,
      "sellerName": "Loki Odinson"
    }
  ],
  ...
```
#
O professor deverá ser capaz de fazer um simples clone do projeto Github, e importar e executar o mesmo na
IDE sem necessidade de qualquer configuração especial diferente daquelas das aulas.</br>
