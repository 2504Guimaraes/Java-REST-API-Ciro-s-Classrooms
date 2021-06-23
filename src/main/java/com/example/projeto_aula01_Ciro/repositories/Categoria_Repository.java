package com.example.projeto_aula01_Ciro.repositories;

import com.example.projeto_aula01_Ciro.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Categoria_Repository extends JpaRepository<Categoria, Long> {
}
