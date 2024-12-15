package PN2.P1.Z6;

public class Vector3D extends Vector {

    public Vector3D(int x1, int y1, int z1, int x2, int y2, int z2) {
        super(x1, y1, z1, x2, y2, z2);
    }

    @Override
    public double getLength() {
        double a = Math.pow(x1 - x2, 2);
        double b = Math.pow(y1 - y2, 2);
        double c = Math.pow(z1 - z2, 2);
        return Math.sqrt(a + b + c);
    }

    @Override
    public String getVectorCords() {
        return (x2 - x1) + " " + (y2 - y1) + " " + (z2 - z1);
    }

    public double getScalarProduct(Vector3D vector3D) {
        String cords = getVectorCords();
        String cords2 = vector3D.getVectorCords();

        Integer a = Integer.parseInt(cords.split(" ")[0]) * Integer.parseInt(cords2.split(" ")[0]);
        Integer b = Integer.parseInt(cords.split(" ")[1]) * Integer.parseInt(cords2.split(" ")[1]);
        Integer c = Integer.parseInt(cords.split(" ")[2]) * Integer.parseInt(cords2.split(" ")[2]);
        return a + b + c;
    }
}
