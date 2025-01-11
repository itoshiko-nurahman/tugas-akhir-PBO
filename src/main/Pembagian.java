package main;

public class Pembagian implements Operasi {
    @Override
    public double hitung(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Pembagian dengan nol");
        }
        return a / b;
    }
}