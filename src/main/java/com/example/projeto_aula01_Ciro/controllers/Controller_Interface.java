package com.example.projeto_aula01_Ciro.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Controller_Interface<T> {
    ResponseEntity<List<T>> getAll();
    ResponseEntity<?> get(Long id);
    ResponseEntity<T> post(T obj);
    ResponseEntity<?> put(T obj);
    ResponseEntity<?> delete(Long id);
}
