package com.sfedu.impl;

public class Aligner {

    public void alignExponents(MyReal num1, MyReal num2){
        if (num1.getExponent() == num2.getExponent())
            return;

        if (num1.getExponent() > num2.getExponent()) {
            long difference = num1.getExponent() - num2.getExponent();
            num2.setMantissa(num2.getMantissa() * (int)Math.pow(10, difference));
            num2.setExponent(num1.getExponent());
        } else {
            long difference = num2.getExponent() - num1.getExponent();
            num1.setMantissa(num1.getMantissa() * (int)Math.pow(10, difference));
            num1.setExponent(num2.getExponent());
        }
    }
}