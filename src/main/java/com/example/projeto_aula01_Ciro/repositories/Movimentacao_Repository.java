package com.example.projeto_aula01_Ciro.repositories;

import com.example.projeto_aula01_Ciro.models.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Movimentacao_Repository
    extends JpaRepository<Movimentacao, Long> {
}
