package com.example.projeto_aula01_Ciro.controllers;

import com.example.projeto_aula01_Ciro.models.Conta_Bancaria;
import com.example.projeto_aula01_Ciro.services.Conta_Bancaria_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        Conta_Bancaria _conta = servico.acharConta(id);
        if (_conta != null)
            return ResponseEntity.ok(_conta);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Conta_Bancaria> post(@RequestBody Conta_Bancaria novaConta) {
        servico.criarNovaConta(novaConta);
        return ResponseEntity.ok(novaConta);
    }
}
