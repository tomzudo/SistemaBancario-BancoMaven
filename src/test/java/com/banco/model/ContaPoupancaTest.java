package com.banco.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    class ContaPoupancaTest {
    @Test
    void deveImpedirDadosInválidos(){
        assertAll(

            () -> assertThrows(IllegalArgumentException.class, 
                () -> new ContaPoupanca("", 100)),
            
            () -> assertThrows(IllegalArgumentException.class, 
                () -> new ContaPoupanca("Tom", -100)),

            () -> assertThrows(IllegalArgumentException.class, 
                () -> new ContaPoupanca(null, 100))
            );
    }
}
