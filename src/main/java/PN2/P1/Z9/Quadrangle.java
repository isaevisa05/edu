package PN2.P1.Z9;

public abstract class Quadrangle {

    int a;
    int b;
    String color;

    public Quadrangle(int a, int b, String color) {
        this.a = a;
        this.b = b;
        this.color = color;
    }

    public abstract double getLargeDiagonal();
    public abstract double getHeight();
    public abstract String getColor();

}
