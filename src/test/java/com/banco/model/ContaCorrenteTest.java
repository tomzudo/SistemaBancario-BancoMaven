package com.banco.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaCorrenteTest {
    
    @Test
    void deveImpedirDadosInválidos(){
        assertAll(

            () -> assertThrows(IllegalArgumentException.class, 
                () -> new ContaCorrente("", 100)),
            
            () -> assertThrows(IllegalArgumentException.class, 
                () -> new ContaCorrente("Tom", -100)),

            () -> assertThrows(IllegalArgumentException.class, 
                () -> new ContaCorrente(null, 100))
            );
    }

}