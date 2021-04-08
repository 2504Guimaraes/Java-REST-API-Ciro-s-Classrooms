package com.example.projeto_aula01_Ciro.models;

import java.util.Calendar;

public class Movimentacao extends AbstractyEntity {
    private static final long serialVersionUID = 1L;

    private Float valor;
    private TipoMovimentacao tipo;
    private String descricao;
    private Calendar data;
}
