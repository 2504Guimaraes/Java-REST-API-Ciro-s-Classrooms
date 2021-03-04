package com.example.projeto_aula01_Ciro.models;

import java.io.Serializable;
import java.util.Objects;

public class Conta_Bancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    private  static Long nextId = 1L;

    private Long idContaBancaria;
    private Integer numeroAgencia;
    private String  numeroConta;
    private String nomeTitular;
    private Float saldo;

    public Conta_Bancaria() { }

    public Conta_Bancaria(Long id_Inserido) {
        this.idContaBancaria = id_Inserido;
    }

    // Setters:

    public void setIdContaBancaria(Long idInserido) {
        this.idContaBancaria = idInserido;
    }

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

    public Long getIdContaBancaria() {
        return this.idContaBancaria;
    }

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


    // Geração de ID Incremental:

    public Long generateId() {
        return nextId++;
    }

    // Métodos HashCode e Equals:

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta_Bancaria that = (Conta_Bancaria) o;
        return idContaBancaria.equals(that.idContaBancaria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContaBancaria);
    }
}
