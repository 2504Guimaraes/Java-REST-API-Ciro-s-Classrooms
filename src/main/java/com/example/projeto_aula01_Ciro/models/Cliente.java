package com.example.projeto_aula01_Ciro.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_cliente")
public abstract class Cliente extends AbstractyEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "nm_cliente", length = 60)
    private String nome;
    @Column(name = "ds_endereco", length = 120)
    private String endereco;

    @OneToOne
    private Conta_Bancaria conta;

    public Cliente() { }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
