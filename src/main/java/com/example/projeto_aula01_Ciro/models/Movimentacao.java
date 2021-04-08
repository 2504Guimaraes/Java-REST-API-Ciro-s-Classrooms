package com.example.projeto_aula01_Ciro.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Calendar;


@Table(name="tb_movimentacao")
@Entity
public class Movimentacao extends AbstractyEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "vl_movimentacao")
    private Float valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "nm_tipo_movimentacao")
    private TipoMovimentacao tipo;

    @Column(name = "ds_descricao", length = 100)
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd")
    @Column(name = "dt_movimentacao")
    private Calendar data;

    @ManyToOne(fetch = FetchType.LAZY)
    private Conta_Bancaria conta;

    @JsonIgnore
    public Conta_Bancaria getConta() {
        return conta;
    }

    @JsonProperty
    public void setConta(Conta_Bancaria conta) {
        this.conta = conta;
    }

    public Movimentacao () {
        super();
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
}
