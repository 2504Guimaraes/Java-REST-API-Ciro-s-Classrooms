package com.example.projeto_aula01_Ciro.services;

import com.example.projeto_aula01_Ciro.models.Movimentacao;
import com.example.projeto_aula01_Ciro.repositories.Movimentacao_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Movimentacao_Service implements Service_Interface<Movimentacao> {

    @Autowired
    private Movimentacao_Repository repository;

    @Override
    public Movimentacao create(Movimentacao obj) {
        repository.save(obj);
        return obj;
    }

    @Override
    public Movimentacao findById(Long id) {
        Optional<Movimentacao> _conta = repository.findById(id);
        return _conta.orElse(null);
    }

    @Override
    public List<Movimentacao> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(Movimentacao obj) {
        if (repository.existsById(obj.getId())) {
            repository.save(obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

