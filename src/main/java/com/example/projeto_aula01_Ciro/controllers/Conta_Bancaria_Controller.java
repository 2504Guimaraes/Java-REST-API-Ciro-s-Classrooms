package com.example.projeto_aula01_Ciro.controllers;

import com.example.projeto_aula01_Ciro.models.Conta_Bancaria;
import com.example.projeto_aula01_Ciro.services.Conta_Bancaria_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contas-bancarias")
public class Conta_Bancaria_Controller {

    @Autowired
    private Conta_Bancaria_Service servico;

    @GetMapping
    public ResponseEntity<List<Conta_Bancaria>> pegarTodasAsContas() {
        return ResponseEntity.ok(servico.acharTodasAsContas());
    }


}
