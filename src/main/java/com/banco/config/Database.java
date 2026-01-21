package com.banco.config;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {


    public static void inicializar() {
        try (Connection conn = SQLiteConnection.conectar()) {
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS contas ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nome TEXT NOT NULL,"
            + "saldo REAL NOT NULL,"
            + "tipo TEXT NOT NULL" // corrente ou poupanca
            + ");";
        stmt.execute(sql);
    
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar estrutura do banco", e);
        }
    }
}