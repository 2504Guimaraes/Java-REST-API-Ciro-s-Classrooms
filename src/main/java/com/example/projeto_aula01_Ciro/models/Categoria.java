package com.example.projeto_aula01_Ciro.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria extends AbstractyEntity {
    private static final long serialVersionUID = 1L;
    @Column(name = "nm_categoria", length = 50)
    String nome;

    public Categoria() { }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
