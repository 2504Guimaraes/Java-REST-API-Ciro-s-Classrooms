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
- IV. Criação de classe **Movimentacao** e Enum **TipoMovimentacao** para auxilio da classe
"possesora", **Conta_Bancaria** :
  - O Enum **TipoMovimentacao** atuará como atributo categorizador da classe **Movimentação**,
    quando a mesma for mostrada em alguma tabela do banco, por meio do identificador
       `@Enumerated(EnumType.STRING)`.
       - Caso contrário o comportamento default do Hibernate será justo mostrar a categoria do Tipo de
        Movimentação de maneira binária e numérica já que o Enum o qual ela foi baseada só possuí 2 valores 
        possíveis.
- V. Adicionados identificadores `@JoinColumn`, `@JsonIgnore` e `@JsonProperty` na classe 
**Conta_Bancaria**:
  - `@JoinColumn` impede  o Hibernate de criar uma tabela do tipo **entidade de relacionamento** na
    relação *One to Many*. Assim só gerando mais uma coluna que indica o ID da Conta Bancária a
    qual cada movimentação pertence.
  - `@JsonIgnore` impede a renderização do JSON da movimentação (que é uma informação privada à pessoa)
  dentro das chamadas HTTP.
  - `@JsonProperty` faz com que cada movimentação seja gerada caso dados em formato JSON sejam
    passados a respeito dela.