import java.awt.*;

public class Cars implements Movable {

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    private double x_coordinate = 0;
    private double y_coordinate = 0;
    protected Directions direction;

    public enum Directions {
        EAST,
        WEST,
        NORTH,
        SOUTH
    }

    public Directions getDirection() {
        return direction;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public double getX() {
        return this.x_coordinate;
    }

    public double getY() {
        return this.y_coordinate;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min((getCurrentSpeed() + (speedFactor() * amount)), enginePower);
    }

    protected double speedFactor() {
        return 0;
    }

    public void gas(double amount) {
        if (0.0D <= amount && amount <= 1.0D) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (0.0D <= amount && amount <= 1.0D) {
            decrementSpeed(amount);
        }
    }

    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max((getCurrentSpeed() - (speedFactor() * amount)), 0);
    }

    public void move() {
        if (direction == Directions.WEST) {
            x_coordinate -= getCurrentSpeed();
        } else if (direction == Directions.EAST) {
            x_coordinate += getCurrentSpeed();
        } else if (direction == Directions.SOUTH) {
            y_coordinate -= getCurrentSpeed();
        } else {
            y_coordinate = y_coordinate + getCurrentSpeed();
        }
    }

    public void turnLeft() {
        if (direction == Directions.NORTH) {
            this.direction = Directions.WEST;
        } else if (direction == Directions.WEST) {
            this.direction = Directions.SOUTH;
        } else if (direction == Directions.SOUTH) {
            this.direction = Directions.EAST;
        } else  {
            this.direction = Directions.NORTH;
        }
    }

    public void turnRight() {
        if (direction == Directions.NORTH) {
            this.direction = Directions.EAST;
        } else if (direction == Directions.WEST) {
            this.direction = Directions.NORTH;
        } else if (direction == Directions.SOUTH) {
            this.direction = Directions.WEST;
        } else  {
            this.direction = Directions.SOUTH;
        }
    }
}



