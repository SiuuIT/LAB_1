import java.awt.*;

public class Saab extends Cars{
    protected boolean turboOn;
    protected Saab(int x, int y){
        direction = Directions.NORTH;
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }
    protected void setTurboOn(){
        turboOn = true;
    }
    protected void setTurboOff(){ turboOn = false; }

    public boolean getTurbo(){
        return turboOn;

    }

    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}