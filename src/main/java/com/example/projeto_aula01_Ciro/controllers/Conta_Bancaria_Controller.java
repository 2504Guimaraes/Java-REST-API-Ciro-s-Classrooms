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
public class Conta_Bancaria_Controller
        implements Controller_Interface<Conta_Bancaria> {


    @Autowired
    private Conta_Bancaria_Service servico;


    @Override
    @GetMapping
    public ResponseEntity<List<Conta_Bancaria>> getAll() {
        return ResponseEntity.ok(servico.findAll());
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        Conta_Bancaria _conta = servico.findById(id);
        if (_conta != null)
            return ResponseEntity.ok(_conta);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<Conta_Bancaria> post(@RequestBody Conta_Bancaria novaConta) {
        servico.create(novaConta);
        return ResponseEntity.ok(novaConta);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> put(@RequestBody Conta_Bancaria conta) {
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

    // Usar métodos GET e PUT como referência, pois
    // o Get dá exemplo de como especificar o objeto que eu desejo
    // modificar do BD por meio da query string / path variable.
    // Já o método PUT contém um método interno, parecido com o que
    // eu irei construir p/ modificar o objeto, chamado servico.atualizar(conta);

    // Exercício 1.1: depositar(Long id, Float valor)

    /*
    @PutMapping(value = "depositar/{id}/{valor_depositado}")
    public ResponseEntity<?> depositar(
            @PathVariable("id") Long id,
            @PathVariable("valor_depositado") Float valor) {

        Conta_Bancaria _conta = servico.acharConta(id);
        if (_conta != null) {
            if (servico.atualizarSaldo(_conta, valor))
                return ResponseEntity.ok(_conta.getSaldo());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    } */

    // Exercício 1.2: sacar(Long id, Float valor)
    // Nota: quando for fazer um novo método de requisição com parâmetros iguais,
    // sertifique-se de que a rota foi alterada, para que o protocólo HTTP consiga diferenciar
    // uma requisição da outra. Se não ele vai achar ambos os métodos ambíguos e dará erro 500.

    /*
    @PutMapping(value = "sacar/{id}/{valor_sacado}")
    public ResponseEntity<?> sacar(
            @PathVariable("id") Long id,
            @PathVariable("valor_sacado") Float valor) {

        Conta_Bancaria _conta = servico.acharConta(id);
        if (_conta != null) {
            if (servico.sacarValor(_conta, valor))
                return ResponseEntity.ok(valor);
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    */
}
