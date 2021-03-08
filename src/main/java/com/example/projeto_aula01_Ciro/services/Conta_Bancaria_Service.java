package com.example.projeto_aula01_Ciro.services;

import com.example.projeto_aula01_Ciro.models.Conta_Bancaria;
import com.example.projeto_aula01_Ciro.repositories.Conta_Bancaria_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Conta_Bancaria_Service implements Service_Interface<Conta_Bancaria>{

    @Autowired
    private Conta_Bancaria_Repository repository;

    @Override
    public Conta_Bancaria create(Conta_Bancaria obj) {
        repository.save(obj);
        return obj;
    }

    @Override
    public Conta_Bancaria findById(Long id) {
        Optional<Conta_Bancaria> _conta = repository.findById(id);
        return _conta.orElse(null);
    }

    @Override
    public List<Conta_Bancaria> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(Conta_Bancaria obj) {
        if (repository.existsById(obj.getIdContaBancaria())) {
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
