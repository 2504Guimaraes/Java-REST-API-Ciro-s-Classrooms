package com.example.projeto_aula01_Ciro.services;

import com.example.projeto_aula01_Ciro.models.Categoria;
import com.example.projeto_aula01_Ciro.repositories.Categoria_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Categoria_Service implements Service_Interface<Categoria> {

    @Autowired
    private Categoria_Repository repository;

    @Override
    public Categoria create(Categoria obj) {
        repository.save(obj);
        return obj;
    }

    @Override
    public Categoria findById(Long id) {
        Optional<Categoria> _categoria = repository.findById(id);
        return _categoria.orElse(null);
    }

    @Override
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(Categoria obj) {
        if (repository.existsById(obj.getId())) {
            repository.save(obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById((id));
            return true;
        }
        return false;
    }
}
