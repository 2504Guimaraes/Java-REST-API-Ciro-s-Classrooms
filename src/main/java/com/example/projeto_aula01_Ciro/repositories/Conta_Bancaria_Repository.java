package com.example.projeto_aula01_Ciro.repositories;

import com.example.projeto_aula01_Ciro.models.Conta_Bancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Conta_Bancaria_Repository
        extends JpaRepository <Conta_Bancaria, Long> {

}
