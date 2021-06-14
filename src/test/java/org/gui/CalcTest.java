package org.gui;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {
    static Calc calc;

    @BeforeAll
    public static void init() {
        calc = new Calc();
    }

    @Test
    public void czyDodajePrawidlowo() {
        assertEquals(calc.add(10, 20), 30);
    }

    @Test
    public void czyOdejmujePrawidlowo() {
        assertEquals(calc.substract(30, 20), 10);
    }

    @Test
    public void czyDzieliPrawidlowo() {
        assertEquals(calc.divide(10, 5), 2);
    }

    @Test
    public void czyMnozyPrawidlowo() {
        assertEquals(calc.multiply(10, 2), 20);
    }
}
