package com.sfedu.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomDecimalTest {

    @Test
    void numberPiShouldTransformFromDoubleToMantissaAndExponent(){
        MyReal customDecimal = new MyReal(3.141569);

        assertEquals(3141569, customDecimal.getMantissa());
        assertEquals(-6, customDecimal.getExponent());
    }
}