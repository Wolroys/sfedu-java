package com.sfedu.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void polizTest(){
        Calc calc = new Calc("1 + 2 * 3");

        assertEquals("1 2 3 * +", calc.toPoliz());

        calc = new Calc("( 1 + 2 ) * 3");

        assertEquals("1 2 + 3 *", calc.toPoliz());
    }

    @Test
    void calculateTest(){
        Calc calc = new Calc("1 + 2 * 3");

        assertEquals(7.0, calc.calculate(), 0.00001);

        calc = new Calc("( 1 + 2 ) * 3");

        assertEquals(9.0, calc.calculate(), 0.00001);
    }
}