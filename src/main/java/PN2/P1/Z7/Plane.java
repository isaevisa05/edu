package PN2.P1.Z7;

public class Plane extends Transport {

    public Plane(int fuel, int speed) {
        super(fuel, speed);
    }

    @Override
    public boolean canMove(int n) {
        if(fuel < n) return false;
        fuel = fuel - n;
        return true;
    }

    @Override
    public int getFuelLevel() {
        return fuel;
    }

    public void fillFuel(int n) {
        this.fuel = fuel + n;
    }
}
