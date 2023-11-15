import java.awt.*;
public class Scania extends Cars {
    protected Scania() {
        direction = Directions.NORTH;
        nrDoors = 2;
        color = Color.blue;
        enginePower = 400;
        modelName = "Scania";
        stopEngine();
    }

    private double truckBedAngle = 0;

    @Override
    protected double speedFactor() {
        return 1;
    }

    public double getTruckBedAngle() {
        return this.truckBedAngle;
    }

    public void raiseAngle(double amount) {
        boolean b = this.getCurrentSpeed() == 0;
        if (b) {
            truckBedAngle += amount;
            this.enginePower = 0;
            if (truckBedAngle > 70) {
                truckBedAngle = 70;
            }
        }
    }

    public void lowerAngle(double amount) {
        boolean b = this.getCurrentSpeed() == 0;
        if (b) {
            truckBedAngle -= amount;
            if (truckBedAngle < 0 || truckBedAngle == 0) {
                truckBedAngle = 0;
                enginePower = 400;
            }
        }
    }

    @Override
    public void startEngine() {
        if (this.enginePower != 0) {
            super.startEngine();
        }
    }
}