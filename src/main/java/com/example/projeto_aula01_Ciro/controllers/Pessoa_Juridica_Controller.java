package com.example.projeto_aula01_Ciro.controllers;

import com.example.projeto_aula01_Ciro.models.PessoaJuridica;
import com.example.projeto_aula01_Ciro.services.Pessoa_Juridica_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas-juridicas")
public class Pessoa_Juridica_Controller implements Controller_Interface<PessoaJuridica> {

    @Autowired
    private Pessoa_Juridica_Service servico;


    @Override
    @GetMapping
    public ResponseEntity<List<PessoaJuridica>> getAll() {
        return ResponseEntity.ok(servico.findAll());
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        PessoaJuridica _conta = servico.findById(id);
        if (_conta != null)
            return ResponseEntity.ok(_conta);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<PessoaJuridica> post(@RequestBody PessoaJuridica novaConta) {
        servico.create(novaConta);
        return ResponseEntity.ok(novaConta);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> put(@RequestBody PessoaJuridica conta) {
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
