package com.banco.model;


public class ContaCorrente extends ContaBancaria {


    public ContaCorrente(String nome, double saldo) {
        super(nome, saldo);
    }
    
    @Override
    public String getTipo() {
        return "corrente";
    }
}