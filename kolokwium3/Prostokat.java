package com.company;

public class Prostokat {
    private double a;
    private double b;

    public Prostokat(double bok1, double bok2) {
        a = bok1;
        b = bok2;
    }

    public double przekatna() {
        return  Math.sqrt((a * a) + (b * b));
    }

    public double przekatna(double v) {
        return Math.sqrt((a * a) + (b * b)) * v;
    }
}
