import java.awt.*;
public class Scania extends Cars {
    protected Scania() {
        direction = Directions.NORTH;
        nrDoors = 2;
        color = Color.blue;
        enginePower = 400;
        modelName = "temp";
        stopEngine();
    }

    private double truckBedAngle = 0;

        @Override
    public double speedFactor () {
        return 1;
        }

    public double getTruckBedAngle () {
        return this.truckBedAngle;
    }

    public void raiseAngle ( double amount){
        boolean b = this.getCurrentSpeed() == 0;
        if (b) {
            truckBedAngle += amount;
            if (truckBedAngle > 70) {
                truckBedAngle = 70;
            }
        }
    }
    public void lowerAngle ( double amount){
        boolean b = this.getCurrentSpeed() == 0;
        if (b) {
            truckBedAngle -= amount;
            if (truckBedAngle < 0) {
                truckBedAngle = 0;
            }
        }
    }
}
