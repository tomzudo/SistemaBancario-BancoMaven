package com.banco.model;


public class ContaPoupanca extends ContaBancaria {


    public ContaPoupanca(String nome, double saldo) {
        super(nome, saldo);
    }

    @Override
    public String getTipo() {
        return "poupanca";
    }
}