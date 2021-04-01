package com.example.projeto_aula01_Ciro.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "tb_cliente")
public class Cliente extends AbstractyEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "nm_cliente", length = 60)
    private String nome;
    @Column(name = "ds_endereco", length = 120)
    private String endereco;

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
