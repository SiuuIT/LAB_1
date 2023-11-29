import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Cars> cars = new ArrayList<>();


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo());
        cc.cars.add(new Saab());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cars car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                //getPosition(). maybe
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                if (car.getX() > Math.abs(800) || car.getY() > Math.abs(530)){
                    car.brake(1);
                    if(car.direction == Cars.Directions.SOUTH){
                    car.direction = Cars.Directions.NORTH;
                    }
                    car.currentSpeed = 1;
                }
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Cars car : cars
                ) {
            car.gas(gas);
        }
    }// Calls the brake method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Cars car : cars) {
        car.brake(brake);
        }
    }
    void turnLeft() {
        for (Cars car : cars) {
            car.turnLeft();
        }
    }
    void turnRight(){
        for(Cars car : cars){
            car.turnRight();
            }
        }
    void setTurboOn(){

        saab.setTurboOn(); //????????????????????????????
    }
    void lowerBed(){
        for()
    }
}
