package com.sfedu.impl;

import java.math.BigDecimal;

public class MyReal {

    private long mantissa;

    private long exponent;

    public MyReal(long mantissa, long exponent) {
        this.mantissa = mantissa;
        this.exponent = exponent;
    }

    public MyReal(double number){
        BigDecimal bd = new BigDecimal(Double.toString(number));
        this.mantissa = bd.unscaledValue().longValue();
        this.exponent = -bd.scale();
        normalize();
    }


    private void normalize() {
        while (this.mantissa % 10 == 0 && this.mantissa != 0) {
            this.mantissa /= 10;
            this.exponent++;
        }
    }

    public boolean less(MyReal other){
        if (this.exponent != other.exponent)
            return this.exponent < other.exponent;

        return this.mantissa < other.mantissa;
    }

    public boolean greater(MyReal other){
        if (this.exponent != other.exponent)
            return this.exponent > other.exponent;

        return this.mantissa > other.mantissa;
    }

    public boolean equal(MyReal other){
        return this.exponent == other.exponent && this.mantissa == other.mantissa;
    }

    public MyReal add(MyReal other){
        double thisNumber = this.mantissa * Math.pow(10, this.exponent);
        double otherNumber = other.mantissa * Math.pow(10, other.exponent);

        return new MyReal(thisNumber + otherNumber);
    }

    public MyReal subtract(MyReal other){
        double thisNumber = this.mantissa * Math.pow(10, this.exponent);
        double otherNumber = other.mantissa * Math.pow(10, other.exponent);

        return new MyReal(thisNumber - otherNumber);
    }

    public MyReal multiply(MyReal other){
        double thisNumber = this.mantissa * Math.pow(10, this.exponent);
        double otherNumber = other.mantissa * Math.pow(10, other.exponent);

        return new MyReal(thisNumber * otherNumber);
    }

    public MyReal divide(MyReal other){
        double thisNumber = this.mantissa * Math.pow(10, this.exponent);
        double otherNumber = other.mantissa * Math.pow(10, other.exponent);

        return new MyReal(thisNumber / otherNumber);
    }

    public MyReal sin() {
        MyReal result = new MyReal(0, 0);
        MyReal term = new MyReal(this.mantissa, this.exponent);

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                result = result.add(term);
            } else {
                result = result.subtract(term);
            }

            term = term
                    .multiply(this)
                    .multiply(this)
                    .divide(new MyReal((2 * i + 2) * (2 * i + 3), 0));
        }

        return result;
    }

    public MyReal cos() {
        MyReal result = new MyReal(1, 0);
        MyReal term = new MyReal(1, 0);

        for (int i = 0; i < 100; i++) {
            term = term
                    .multiply(this)
                    .multiply(this)
                    .divide(new MyReal((2 * i + 1) * (2 * i + 2), 0));

            if (i % 2 == 0) {
                result = result.subtract(term);
            } else {
                result = result.add(term);
            }
        }

        return result;
    }

    public long getMantissa() {
        return mantissa;
    }

    public void setMantissa(long mantissa) {
        this.mantissa = mantissa;
    }

    public long getExponent() {
        return exponent;
    }

    public void setExponent(long exponent) {
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        return "CustomDecimal{" +
                "mantissa=" + mantissa +
                ", exponent=" + exponent +
                '}';
    }

    public double toDouble(){
        return (double) this.mantissa * Math.pow(10, this.exponent);
    }
}
