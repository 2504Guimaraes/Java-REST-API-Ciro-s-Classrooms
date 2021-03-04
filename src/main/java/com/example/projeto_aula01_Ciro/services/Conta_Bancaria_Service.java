package com.example.projeto_aula01_Ciro.services;

import com.example.projeto_aula01_Ciro.models.Conta_Bancaria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Conta_Bancaria_Service {

    private static List<Conta_Bancaria> contasBancarias = new ArrayList<>();

    public Conta_Bancaria_Service() { }

    // Adiciona um novo um novo obj. do tipo Conta Bancária a minha lista:

    public void criarNovaConta(Conta_Bancaria conta) {
        conta.setIdContaBancaria(conta.generateId());
        contasBancarias.add(conta);
    }

    public List<Conta_Bancaria> acharTodasAsContas() {
        return  contasBancarias;
    }

    public Conta_Bancaria acharConta(Conta_Bancaria conta) {
        for (Conta_Bancaria c : contasBancarias) {
            if (c.equals(conta))
                return c;
        }
        return null;
    }

    // Sobrecarga do método acharConta:
    public Conta_Bancaria acharConta(Long id) {
        return acharConta(new Conta_Bancaria(id));
    }

    public boolean atualizar(Conta_Bancaria conta) {
        Conta_Bancaria _conta = acharConta(conta);
        if (_conta != null) {
            _conta.setNumeroAgencia(conta.getNumeroAgencia());
            _conta.setNumeroConta(conta.getNumeroConta());
            _conta.setNomeTitular(conta.getNomeTitular());
            _conta.setSaldo(conta.getSaldo());
            return true;
        }
        return false;
    }

    public boolean deletar(Long id) {
        Conta_Bancaria _conta = acharConta(id);
        if (_conta != null) {
            contasBancarias.remove(_conta);
            return true;
        }
        return false;
    }
}
