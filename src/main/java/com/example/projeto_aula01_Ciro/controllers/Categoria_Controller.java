package com.example.projeto_aula01_Ciro.controllers;

import com.example.projeto_aula01_Ciro.models.Categoria;
import com.example.projeto_aula01_Ciro.services.Categoria_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class Categoria_Controller implements Controller_Interface<Categoria> {

    @Autowired
    private Categoria_Service servico;

    @Override
    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return  ResponseEntity.ok(servico.findAll());
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        Categoria _categoria = servico.findById(id);
        if (_categoria != null)
            return ResponseEntity.ok(_categoria);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<Categoria> post(@RequestBody Categoria novaCategoria) {
        servico.create(novaCategoria);
        return ResponseEntity.ok(novaCategoria);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> put(@RequestBody Categoria categoria) {
        if (servico.update(categoria))
                return ResponseEntity.ok(categoria);
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
