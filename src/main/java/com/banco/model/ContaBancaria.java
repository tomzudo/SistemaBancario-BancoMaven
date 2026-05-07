package com.banco.model;

public abstract class ContaBancaria {
    protected int id;
    protected String nome;
    protected double saldo;

    public ContaBancaria(String nome, double saldo) {
        setNome(nome);
        setSaldo(saldo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome de titular invalido");
        }
        this.nome = formatar(nome);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validarSaldoPositivo(saldo);
        this.saldo = saldo;
    }

    public static String formatar(String texto) {
        return texto.trim().toLowerCase();
    }

    public static void validarSaldoPositivo(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor nao pode ser negativo");
        }
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor > saldo)
            return false;
        saldo -= valor;
        return true;
    }

    public void validarInt(int numero) {

    }

    public abstract String getTipo();

    public String toString() {
        return getTipo() +
                " | Nome: " + nome +
                " | Saldo: " + saldo;
    }

}