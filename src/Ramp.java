public class Ramp {
    private boolean raised;
    private double angle;

    public Ramp() {
        this.raised = false;
        this.angle = 0;
    }

    public boolean isRaised() {
        return raised;
    }

    public double getAngle() {
        return angle;
    }

    public void raise(double amount) {
        angle += amount;
        if (angle > 70){
            angle = 70;
        }
    }
    public void rampUp(){
        raised = true;
    }
    public void rampDown(){
        raised = false;
    }
    public void lower(double amount) {
        angle -= amount;
        if (angle < 0) {
            angle = 0;
        }
    }
}