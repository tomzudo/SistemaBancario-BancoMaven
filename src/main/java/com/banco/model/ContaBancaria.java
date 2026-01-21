package com.banco.model;


public abstract class ContaBancaria {
    protected int id;
    protected String nome;
    protected double saldo;

    public ContaBancaria(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public void depositar(double valor) { this.saldo += valor; }


    public boolean sacar(double valor) {
        if (valor > saldo) return false;
            saldo -= valor;
            return true;
    }

    public void validarInt(int numero){            
        
    }

    public abstract String getTipo();

    public String toString() {
        return getTipo() +
            " | Nome: " + nome +
            " | Saldo: " + saldo;
    }

}