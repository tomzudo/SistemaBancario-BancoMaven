package com.banco.service;


import com.banco.dao.ContaDAO;
import com.banco.model.*;
 

import java.util.List;

public class ContaService {
    private final ContaDAO dao = new ContaDAO();


    public void criarConta(String nome, double saldo, String tipo) {
        ContaBancaria conta = tipo.equalsIgnoreCase("corrente")
            ? new ContaCorrente(nome, saldo)
            : new ContaPoupanca(nome, saldo);

        dao.salvar(conta);
    }

    public List<ContaBancaria> ListarContas() {
        return dao.listar();
    }

    public ContaBancaria BuscarPorId(int id){
        return dao.buscarPorId(id);    
    }

    public void Depositar(int id, double valor){        
        ContaBancaria conta = dao.buscarPorId(id);
        conta.depositar(valor);
        dao.atualizarSaldo(conta.getId(), conta.getSaldo());
    }

    public void sacar(int id, double valor){
        ContaBancaria conta = dao.buscarPorId(id);
        conta.sacar(valor);
        dao.atualizarSaldo(conta.getId(), conta.getSaldo());
    }

    public void tranferencia(int id_contaOrigem, int id_ContaDestino, double valor){
        ContaBancaria contaOrigem = dao.buscarPorId(id_contaOrigem);
        ContaBancaria contaDestino = dao.buscarPorId(id_ContaDestino);

        dao.atualizarSaldo(id_contaOrigem, contaOrigem.getSaldo() - valor);
        dao.atualizarSaldo(id_ContaDestino, contaDestino.getSaldo() + valor);
    }

    public void apagarConta(int id){
        dao.excluirConta(id);
    }
}