package PN2.P1.Z7;

public abstract class Transport {

    int fuel;
    int speed;

    public Transport(int fuel, int speed) {
        this.fuel = fuel;
        this.speed = speed;
    }

    public abstract boolean canMove(int n);
    public abstract int getFuelLevel();
}
