package com.sfedu.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalcTest {

    @Test
    void polizTest() {
        Calc calc = new Calc("1 + 2 * 3");

        assertEquals("1 2 3 * +", calc.toPoliz());

        calc = new Calc("( 1 + 2 ) * 3");

        assertEquals("1 2 + 3 *", calc.toPoliz());
    }

    @Test
    void polizTest1() {
        Calc calc = new Calc("2 * ( 3 + 4 )");

        assertEquals("2 3 4 + *", calc.toPoliz());
    }

    @Test
    void polizTest2() {
        Calc calc = new Calc("( 5 + 6 ) * 7");

        assertEquals("5 6 + 7 *", calc.toPoliz());
    }

    @Test
    void calculateTest() {
        Calc calc = new Calc("1 + 2 * 3");

        assertEquals(7.0, calc.calculate(), 0.00001);

        calc = new Calc("( 1 + 2 ) * 3");

        assertEquals(9.0, calc.calculate(), 0.00001);
    }

    @Test
    void calcTest1() {
        Calc calc = new Calc("2 * ( 3 + 4 )");

        assertEquals(14.0, calc.calculate(), 0.00001);
    }

    @Test
    void calcTest2() {
        Calc calc = new Calc("( 5 + 6 ) * 7");

        assertEquals(77.0, calc.calculate(), 0.00001);
    }
}