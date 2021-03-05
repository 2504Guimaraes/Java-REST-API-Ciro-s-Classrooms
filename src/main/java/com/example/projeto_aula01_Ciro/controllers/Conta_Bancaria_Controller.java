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

    @PutMapping
    public ResponseEntity<?> put(@RequestBody Conta_Bancaria conta) {
        if (servico.atualizar(conta))
            return ResponseEntity.ok(conta);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (servico.deletar(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Usar métodos GET e PUT como referência, pois
    // o Get dá exemplo de como especificar o objeto que eu desejo
    // modificar do BD por meio da query string / path variable.
    // Já o método PUT contém um método interno, parecido com o que
    // eu irei construir p/ modificar o objeto, chamado servico.atualizar(conta);

    // Exercício 1.1: depositar(Long id, Float valor)

    @PutMapping(value = "/{id}/{valor_depositado}")
    public ResponseEntity<?> depositar(
            @PathVariable("id") Long id,
            @PathVariable("valor_depositado") Float valor) {

        Conta_Bancaria _conta = servico.acharConta(id);
        if (_conta != null)
            if (servico.atualizarSaldo(_conta, valor))
                return ResponseEntity.ok(_conta);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
