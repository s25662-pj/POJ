package com.company;

public class Kwadrat extends Prostokat {
    private double a;

    public Kwadrat(double bok1, double bok2) {
        super(bok1, bok2);
        a = bok1;
    }

    public Kwadrat(double bok1) {
        super(bok1, bok1);
        a = bok1;
    }

    public double przekatna(double v) {
        return (int) (a * Math.sqrt(2) * v);
    }
}
