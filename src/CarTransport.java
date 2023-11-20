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
        this.ramp = new Ramp();
        carList = new ArrayList<>(10);
        stopEngine();
    }
    public boolean getRamp() {
        return this.ramp.isRaised();
    }
    public void lowerRamp() {
        if (this.currentSpeed == 0) {
            this.enginePower = 0;
            this.ramp.rampDown();
        }
    }
    public void raiseRamp() {
        if (this.currentSpeed == 0) {
            this.enginePower = 300;
            this.ramp.rampUp();
        }
    }
    @Override
    public void startEngine() {
        if (this.getRamp()) {
            this.currentSpeed = 0.1;
        }
    }
    public boolean checkProximity(Cars car) {
        return Math.abs(car.getX() - this.getX()) <= 5 && Math.abs(car.getY() - this.getY()) <= 5;
    }
    public void load(Cars car) {
        if (!(car instanceof CarTransport) && !this.getRamp() && this.checkProximity(car)) {
            carList.add(car);
        }
    }
    public void unload(Cars car) {
        if (this.carList != null && !this.carList.isEmpty()) {
            this.carList.removeLast();
            car.y_coordinate = this.y_coordinate - 15;
            car.x_coordinate = this.x_coordinate - 10;
        }
    }
    public ArrayList<Cars> getLoadedCars() {
        return new ArrayList<>(carList);
    }
    @Override
    public void move() {
        super.move();
        for (Cars car : carList) {
            car.x_coordinate = this.x_coordinate;
            car.y_coordinate = this.y_coordinate;
        }
    }
}