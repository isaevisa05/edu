package PN2.P1.Z9;

public class Parallelogram extends Quadrangle implements Figure {

    double alpha, beta;

    public Parallelogram(int a, int b, double alpha, double beta, String color) {
        super(a, b, color);
        this.alpha = alpha;
        this.beta = beta;
    }

    @Override
    public double area() {
        return Math.max(a, b) * getHeight();
    }

    @Override
    public double perimeter() {
        return (a + b) * 2;
    }

    @Override
    public double getLargeDiagonal() {
        double d1 = Math.sqrt(
                a * a + b * b - 2 * b * a * Math.cos(Math.toRadians(beta))
        );
        double d2 = Math.sqrt(
                a * a + b * b + 2 * b * a * Math.cos(Math.toRadians(alpha))
        );
        return Math.max(d1, d2);
    }

    @Override
    public double getHeight() {
        return Math.min(
                a * Math.sin(Math.toRadians(alpha)),
                b * Math.sin(Math.toRadians(beta))
        );
    }

    @Override
    public String getColor() {
        return color;
    }
}
