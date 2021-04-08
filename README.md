## Arquivo para controle de construção da API REST feita pelo Ciro
Como o título já diz, esse arquivo tem como propósito auxiliar no controle do
código pedido na matéria de Linguagens p/ Desenvolvimento de Servidores II.

### Fase de Produção
Aula 05 - Relacionamentos no JPA

#### Mudanças Importantes feitas
- 1º. Mudança da estratégia de geração de ID'S na classe **AbstractEntity** para
  `GenerationType.IDENTITY`.
  
- 2º. Mudança de método de herança por meio de 
  `@Inheritance(strategy = InheritanceType.JOINED)` na classe **Cliente**.
  
- 3º. Adição dos identificadores `@OneToOne` e `@JoinColumn` para relacionamento Um para Um.
    - Mais os atributos específicos de cada identificador, para controle desde:
      - 1. Configurações de relacionamento entre as entidades.
      - 2. Identificação da foreign key da entidade possuída.
      - 3. Confirmação de relacionamento *Um para Um*.
    
- 4º. Criação de classe **Movimentacao** e Enum **TipoMovimentacao** para auxilio da classe
"possesora", **Conta_Bancaria** :
  - O Enum **TipoMovimentacao** atuará como atributo categorizador da classe **Movimentação**,
    quando a mesma for mostrada em alguma tabela do banco, por meio do identificador
       `@Enumerated(EnumType.STRING)`.
       - Caso contrário o comportamento default do Hibernate será justo mostrar a categoria do Tipo de
        Movimentação de maneira binária e numérica já que o Enum o qual ela foi baseada só possuí 2 valores 
        possíveis.
         
- 5º. Adicionados identificadores `@JoinColumn`, `@JsonIgnore` e `@JsonProperty` na classe 
**Conta_Bancaria**:
  - `@JoinColumn` impede  o Hibernate de criar uma tabela do tipo **entidade de relacionamento** na
    relação *One to Many*. Assim só gerando mais uma coluna que indica o ID da Conta Bancária a
    qual cada movimentação pertence.
  - `@JsonIgnore` impede a renderização do JSON da movimentação (que é uma informação privada à pessoa)
  dentro das chamadas HTTP.
  - `@JsonProperty` faz com que cada movimentação seja gerada caso dados em formato JSON sejam
    passados a respeito dela.
    
- 6º. Criação das classes; **Movimentacao_Service**, **Movimentacao_Controller** e da
interface **Movimentacao_Repository** para que a entidade Movimentação tenha seus devidos end-points.
  
- 7º. Retirando atributo **movimentacoes** da classe **Conta_Bancaria**, para desfazer
a relação `@OneToMany` e assim, substituí-la por uma relação `@ManyToOne`. *Do ponto de vista das tabelas no banco de dados não irá mudar nada, as mesmas tabelas serão geradas.*
  - **Motivo para fazer isso:**
    - Faz mais sentido que uma Movimentação não seja criada junto com a conta
    bancária do seu portador.
      
- 8º. Agora a mudança foi mais flexível ainda. Se antes uma movimentação era cadastrada vinculada
a uma conta bancária por meio de uma relação `@ManyToOne`. Ou mesmo uma conta poderia já ser cadastrada
  tendo suas movimentações consigo (o quê em certos momentos não faz sentido), por meio de uma
  relação `@OneToMany`. Agora podemos fazer ambos, tanto fazer uma nova conta já com suas movimentações,
  quanto uma movimentação nova vinculada a alguma conta pré-existente. Para isso é usada a relação
  **Bidirecional**. 
  - **NOTA:** Ela não tem um identificador. 😅
  - Simplesmente o identificador `@OneToMany`(junto com seu atributo dono, no caso **movimentacoes**) da classe **Conta_Bancaria** é reativado, reafirmando
    a sua relação, e o atributo deste mesmo identificador, `mappedBy = "conta_bancaria"` afirma quem é a classe possesora da 
    relação entre conta bancária e movimentações.
  - Também, os getters e os setters do atributo **movimentacoes** foram reativados para que seus end-points
    possam gerar tais dados relacionados ao mesmo.
  
