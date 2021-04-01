package com.example.projeto_aula01_Ciro.services;

import com.example.projeto_aula01_Ciro.models.PessoaFisica;
import com.example.projeto_aula01_Ciro.repositories.Pessoa_Fisica_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Pessoa_Fisica_Service implements Service_Interface<PessoaFisica> {

    @Autowired
    private Pessoa_Fisica_Repository repository;

    @Override
    public PessoaFisica create(PessoaFisica obj) {
        repository.save(obj);
        return obj;
    }

    @Override
    public PessoaFisica findById(Long id) {
        Optional<PessoaFisica> _conta = repository.findById(id);
        return _conta.orElse(null);
    }

    @Override
    public List<PessoaFisica> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(PessoaFisica obj) {
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
