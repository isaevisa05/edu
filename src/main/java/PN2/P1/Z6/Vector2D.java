package PN2.P1.Z6;

public class Vector2D extends Vector{

    public Vector2D(int x1, int y1, int x2, int y2) {
        super(x1, y1, 0, x2, y2, 0);
    }

    public double getScalarProduct(Vector2D vector2D) {
        String cords = getVectorCords();
        String cords2 = vector2D.getVectorCords();

        Integer a = Integer.parseInt(cords.split(" ")[0]) * Integer.parseInt(cords2.split(" ")[0]);
        Integer b = Integer.parseInt(cords.split(" ")[1]) * Integer.parseInt(cords2.split(" ")[1]);

        return a + b;
    }

    public double getAngle(Vector2D vector2D) {
        if(getLength() != 0 && vector2D.getLength() != 0) {
            return getScalarProduct(vector2D) / (this.getLength() * vector2D.getLength());
        }
        return -2.0d;
    }

    @Override
    public double getLength() {
        double a = Math.pow(x1 - x2, 2);
        double b = Math.pow(y1 - y2, 2);
        return Math.sqrt(a + b);
    }

    @Override
    public String getVectorCords() {
        return (x2 - x1) + " " + (y2 - y1);
    }
}
