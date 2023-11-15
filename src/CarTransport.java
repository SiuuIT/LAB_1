import java.awt.*;
import java.util.ArrayList;
import java.lang.Math;

public class CarTransport extends Cars {
    private boolean ramp;
    private ArrayList<Cars> carList;

    protected CarTransport() {
        direction = Directions.NORTH;
        nrDoors = 2;
        color = Color.green;
        enginePower = 300;
        modelName = "TransportCar";
        ramp = false;
        carList = new ArrayList<>(10);
        stopEngine();
    }

    public boolean getRamp() {
        return this.ramp;
    }

    public void lowerRamp() {
        if (this.currentSpeed == 0) {
            this.enginePower = 0;
            ramp = true;
        }
    }

    public void raiseRamp() {
        this.enginePower = 300;
        ramp = false;
    }

    @Override
    public void startEngine() {
        if (this.enginePower != 0) {
            super.startEngine();
        }
    }

    public boolean checkProximity(Cars car) {
        return Math.abs(car.getX() - this.getX()) <= 5 && Math.abs(car.getY() - this.getY()) <= 5;
        }
    public void lassa(Cars car) {
        if (!(car instanceof CarTransport) && this.getRamp() && this.checkProximity(car)){
                carList.add(car);
            }
        }
    public void lossa() {
        if (this.carList != null && !this.carList.isEmpty()) {
            this.carList.removeLast();
        }
    }
}