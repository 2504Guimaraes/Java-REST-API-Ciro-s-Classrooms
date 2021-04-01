package com.example.projeto_aula01_Ciro.services;

import com.example.projeto_aula01_Ciro.models.PessoaJuridica;
import com.example.projeto_aula01_Ciro.repositories.Pessoa_Juridica_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Pessoa_Juridica_Service implements Service_Interface<PessoaJuridica> {
    
    @Autowired
    private Pessoa_Juridica_Repository repository;
    
    @Override
    public PessoaJuridica create(PessoaJuridica obj) {
        repository.save(obj);
        return obj;
    }

    @Override
    public PessoaJuridica findById(Long id) {
        Optional<PessoaJuridica> _conta = repository.findById(id);
        return _conta.orElse(null);
    }

    @Override
    public List<PessoaJuridica> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(PessoaJuridica obj) {
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
