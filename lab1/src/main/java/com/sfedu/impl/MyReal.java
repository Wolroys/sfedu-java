package com.sfedu.impl;

import com.sfedu.Main;

public class MyReal {

    private long mantissa;

    private long exponent;

    public MyReal(long mantissa, long exponent) {
        this.mantissa = mantissa;
        this.exponent = exponent;
    }

    public MyReal(double number){
        String[] parts = String.format("%e", number).split("e");
        this.mantissa = Integer.parseInt(parts[0].replace(",", ""));
        this.exponent = Integer.parseInt(parts[1]) - (parts[0].length() - 2);
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
        double otherNumber = this.mantissa * Math.pow(10, other.exponent);

        return new MyReal(thisNumber + otherNumber);
    }

    public MyReal subtract(MyReal other){
        double thisNumber = this.mantissa * Math.pow(10, this.exponent);
        double otherNumber = this.mantissa * Math.pow(10, other.exponent);

        return new MyReal(thisNumber - otherNumber);
    }

    public MyReal multiply(MyReal other){
        double thisNumber = this.mantissa * Math.pow(10, this.exponent);
        double otherNumber = this.mantissa * Math.pow(10, other.exponent);

        return new MyReal(thisNumber * otherNumber);
    }

    public MyReal divide(MyReal other){
        double thisNumber = this.mantissa * Math.pow(10, this.exponent);
        double otherNumber = this.mantissa * Math.pow(10, other.exponent);

        return new MyReal(thisNumber / otherNumber);
    }

    public MyReal sin(int terms){
        double x = this.toDouble();
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
}
