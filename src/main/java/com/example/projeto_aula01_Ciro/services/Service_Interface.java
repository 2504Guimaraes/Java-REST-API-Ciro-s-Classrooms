package com.example.projeto_aula01_Ciro.services;

import java.util.List;

public interface Service_Interface<T> {
    T create(T obj);
    T findById(Long id);
    List<T> findAll();
    boolean update(T obj);
    boolean delete(Long id);
}
