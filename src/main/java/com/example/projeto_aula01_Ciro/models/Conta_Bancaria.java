package com.example.projeto_aula01_Ciro.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="Conta_Bancaria")
public class Conta_Bancaria extends AbstractyEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "cd_agencia")
    private Integer numeroAgencia;
    @Column(name = "nm_conta", length = 10)
    private String  numeroConta;
    @Column(name = "nm_titular", length = 100)
    private String nomeTitular;
    @Column(name = "vl_saldo")
    private Float saldo;

    public Conta_Bancaria() { }

    /*
      NOTA:
      hashCode(), equals(),
      setIdContaBancaria() e
      getIdContaBancaria() já são herdados da minha classe abstrata
      AbstractEntity.

      O atributo Long IdContaBancaria e o construtor
      Conta_Bancaria(Long idContaBancaria) também não são mais necessários.
    */

    // Setters:

    public void setNumeroAgencia(Integer numeroInserido) {
        this.numeroAgencia = numeroInserido;
    }

    public void setNumeroConta(String numeroInserido) {
        this.numeroConta = numeroInserido;
    }

    public void setNomeTitular(String nomePessoa) {
        this.nomeTitular = nomePessoa;
    }

    public void setSaldo(Float saldoInserido) {
        this.saldo = saldoInserido;
    }

    // Getters:

    public Integer getNumeroAgencia() {
        return  this.numeroAgencia;
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }

    public String getNomeTitular() {
        return  this.nomeTitular;
    }

    public Float getSaldo() {
        return this.saldo;
    }

    // Métodos HashCode e Equals:
}
