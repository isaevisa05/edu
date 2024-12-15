package PN2.P1.Z9;

public class Rectangle extends Quadrangle implements Figure {

    public Rectangle(int a, int b, String color) {
        super(a, b, color);
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public double perimeter() {
        return (a + b) * 2;
    }

    @Override
    public double getLargeDiagonal() {
        return Math.sqrt(a * a + b * b);
    }

    @Override
    public double getHeight() {
        return Math.min(a, b);
    }

    @Override
    public String getColor() {
        return color;
    }
}
