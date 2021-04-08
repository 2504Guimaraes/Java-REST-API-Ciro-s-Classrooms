package com.example.projeto_aula01_Ciro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Conta_Bancaria")
public class Conta_Bancaria extends AbstractyEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "cd_agencia")
    private Integer numeroAgencia;
    @Column(name = "nm_conta", length = 10)
    private String  numeroConta;
    @Column(name = "vl_saldo")
    private Float saldo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "conta_id")
    private List<Movimentacao> movimentacoes;


    @JsonIgnore
    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    @JsonProperty
    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public Conta_Bancaria() { }

    // Setters:

    public void setNumeroAgencia(Integer numeroInserido) {
        this.numeroAgencia = numeroInserido;
    }

    public void setNumeroConta(String numeroInserido) {
        this.numeroConta = numeroInserido;
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

    public Float getSaldo() {
        return this.saldo;
    }

    // Métodos HashCode e Equals:
}
