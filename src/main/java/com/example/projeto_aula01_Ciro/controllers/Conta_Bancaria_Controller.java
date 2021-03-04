package com.example.projeto_aula01_Ciro.controllers;

import com.example.projeto_aula01_Ciro.services.Conta_Bancaria_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contas-bancarias")
public class Conta_Bancaria_Controller {

    @Autowired
    private Conta_Bancaria_Service servico;


}
