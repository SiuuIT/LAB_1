import java.awt.*;
public class Scania extends Cars {
    private Ramp ramp;
    protected Scania() {
        direction = Directions.NORTH;
        nrDoors = 2;
        color = Color.blue;
        enginePower = 400;
        modelName = "Scania";
        this.ramp = new Ramp();
        stopEngine();
    }
    @Override
    protected double speedFactor() {
        return 1;
    }
    public double getTruckBedAngle() {
        return this.ramp.getAngle();
    }
    public void raiseAngle(double amount) {
        boolean b = this.getCurrentSpeed() == 0;
        if (b) {
            this.ramp.raise(amount);
            if (this.ramp.getAngle() > 0){
                this.enginePower = 0;
                }
            }
        }
    public void lowerAngle(double amount) {
        boolean b = this.getCurrentSpeed() == 0;
        if (b) {
            this.ramp.lower(amount);
            if (this.ramp.getAngle() == 0) {
                this.enginePower = 400;
            }
        }
    }
    @Override
    public void startEngine() {
        if (this.enginePower != 0) {
            this.currentSpeed = 0.1;
        }
    }
}