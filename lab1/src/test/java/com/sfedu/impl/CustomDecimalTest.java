package com.sfedu.impl;


import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.Assert.assertEquals;


public class CustomDecimalTest {

    private static final double DELTA = 0.0001;

    @Test
    public void numberPiShouldTransformFromDoubleToMantissaAndExponent(){
        MyReal customDecimal = new MyReal(3.141569);

        assertEquals(3141569, customDecimal.getMantissa());
        assertEquals(-6, customDecimal.getExponent());
    }

    @Test
    public void methodAddShouldEquals4(){
        MyReal n1 = new MyReal(15, -1);
        MyReal n2 = new MyReal(25, -1);
        MyReal expected = new MyReal(4.0);

        assertEquals(expected.toDouble(), n1.add(n2).toDouble(), 0.00001);
    }

    @Test
    public void methodSubtractShouldEqual1(){
        MyReal n1 = new MyReal(2.5);
        MyReal n2 = new MyReal(15, -1);
        MyReal expected = new MyReal(1);

        assertEquals(expected.toDouble(), n1.subtract(n2).toDouble(), 0.00001);
    }

    @Test
    public void methodMultiplyShouldEqual6(){
        MyReal n1 = new MyReal(2.0);
        MyReal n2 = new MyReal(3, 0);
        MyReal expected = new MyReal(6);

        assertEquals(expected.toDouble(), n1.multiply(n2).toDouble(), 0.00001);
    }

    @Test
    public void methodDivideShouldEqual3(){
        MyReal n1 = new MyReal(9);
        MyReal n2 = new MyReal(3, 0);
        MyReal expected = new MyReal(3);

        assertEquals(expected.toDouble(), n1.divide(n2).toDouble(), 0.00001);
    }

    @Test
    public void bigDecimalSinShouldEqualMyRealSin(){
        MyReal myReal = new MyReal(5, -1);
        BigDecimal bd = new BigDecimal("0.5");

        double expected = sin(bd).doubleValue();
        double actual = myReal.sin().toDouble();
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void bigDecimalSinShouldEqualMyRealCos(){
        MyReal myReal = new MyReal(5, -1);
        BigDecimal bd = new BigDecimal("0.5");

        double expected = cos(bd).doubleValue();
        double actual = myReal.cos().toDouble();
        assertEquals(expected, actual, DELTA);
    }

    private static BigDecimal sin(BigDecimal x) {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal term = x;

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                result = result.add(term);
            } else {
                result = result.subtract(term);
            }

            term = term
                    .multiply(x)
                    .multiply(x)
                    .divide(new BigDecimal((2 * i + 2) * (2 * i + 3)), MathContext.DECIMAL128);
        }

        return result;
    }

    private static BigDecimal cos(BigDecimal x) {
        BigDecimal result = BigDecimal.ONE;
        BigDecimal term = BigDecimal.ONE;

        for (int i = 0; i < 100; i++) {
            term = term
                    .multiply(x)
                    .multiply(x)
                    .divide(new BigDecimal((2 * i + 1) * (2 * i + 2)), MathContext.DECIMAL128);

            if (i % 2 == 0) {
                result = result.subtract(term);
            } else {
                result = result.add(term);
            }
        }

        return result;
    }
}