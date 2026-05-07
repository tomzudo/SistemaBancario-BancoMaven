package com.banco.model;

import com.banco.model.ContaBancaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {
    @Test
    void deveFormatarString() {
        assertEquals("tom", ContaBancaria.formatar("TOM"));
    }
}
