## Arquivo para controle de construção da API REST feita pelo Ciro
Como o título já diz, esse arquivo tem como propósito auxiliar no controle do
código pedido na matéria de Linguagens p/ Desenvolvimento de Servidores II.

### Fase de Produção
Aula 03 - Spring Data + Exercício 02

#### Mudanças Importantes feitas

- **Adição de Dependencias**
    - Adicionanada **spring-boot-starter-data-jpa**, que é a API Java a qual é capaz
    fazer a comunicação entre a aplicação Java e a camada de persistência de dados / Banco.
    - Também adicionada a dependência **mysql-connector-java**; para conexão direta com o JDBC
    MySql.
      

- **Adição da camada Repository**
    - Camada feita para a aplicação se comunicar com o Banco de Dados.

- **Exercício 02** 
    - Criação de tabela seguindo os padrões pedidos para a criação de uma entidade
    no SpringData. Sua API REST também deve herdar seus métodos principais da interface 
    Controller Interface.