package com.example.projeto_aula01_Ciro.repositories;

import com.example.projeto_aula01_Ciro.models.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pessoa_Juridica_Repository
    extends JpaRepository<PessoaJuridica, Long> {
}
