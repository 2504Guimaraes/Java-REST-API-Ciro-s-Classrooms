package com.example.projeto_aula01_Ciro.controllers;

import com.example.projeto_aula01_Ciro.models.PessoaFisica;
import com.example.projeto_aula01_Ciro.services.Pessoa_Fisica_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas-fisicas")
public class Pessoa_Fisica_Controller implements Controller_Interface<PessoaFisica> {

    @Autowired
    private Pessoa_Fisica_Service servico;


    @Override
    @GetMapping
    public ResponseEntity<List<PessoaFisica>> getAll() {
        return ResponseEntity.ok(servico.findAll());
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        PessoaFisica _conta = servico.findById(id);
        if (_conta != null)
            return ResponseEntity.ok(_conta);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<PessoaFisica> post(@RequestBody PessoaFisica novaConta) {
        servico.create(novaConta);
        return ResponseEntity.ok(novaConta);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> put(@RequestBody PessoaFisica conta) {
        if (servico.update(conta))
            return ResponseEntity.ok(conta);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (servico.delete(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
