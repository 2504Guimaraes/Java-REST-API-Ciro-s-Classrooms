## Arquivo para controle de construção da API REST feita pelo Ciro
Como o título já diz, esse arquivo tem como propósito auxiliar no controle do
código pedido na matéria de Linguagens p/ Desenvolvimento de Servidores II.

### Fase de Produção
Aula 05 - Relacionamentos no JPA

#### Mudanças Importantes feitas
- I. Mudança da estratégia de geração de ID'S na classe **AbstractEntity** para
  `GenerationType.IDENTITY`.
- II. Mudança de método de herança por meio de 
  `@Inheritance(strategy = InheritanceType.JOINED)` na classe **Cliente**.
- III. Adição dos identificadores `@OneToOne` e `@JoinColumn` para relacionamento Um para Um.
    - Mais os atributos específicos de cada identificador, para controle desde:
      - 1. Configurações de relacionamento entre as entidades.
      - 2. Identificação da foreign key da entidade possuída.
      - 3. Confirmação de relacionamento *Um para Um*.