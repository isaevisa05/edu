package PN2.P1.Z7;

public class Car extends Transport {

    int maxPassengers;

    public Car(int fuel, int speed, int maxPassengers) {
        super(fuel, speed);
        this.maxPassengers = maxPassengers;
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

    public int getMaxPassengers() {
        return maxPassengers;
    }
}
