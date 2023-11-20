import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScaniaTest {
    private Scania scania;

    @Before
    public void init() {scania = new Scania();}
    @Test
    public void checkIfAngleIsMax70(){
        scania.raiseAngle(70);
        assertEquals(70, scania.getTruckBedAngle(), 0.0);
        scania.raiseAngle(70);
        assertEquals(70, scania.getTruckBedAngle(), 0.0);
    }

    @Test
    public void checkIfAngleIsMinimum0(){
        scania.lowerAngle(9000);
        assertEquals(0, scania.getTruckBedAngle(), 0.0);
    }

    @Test
    public void gasWhenRaisedAngle(){
        scania.raiseAngle(5);
        scania.startEngine();
        scania.gas(10);
        assertEquals(0, scania.currentSpeed,0.0);
    }
    @Test
    public void raiseAngleWhileMoving(){
        scania.startEngine();
        scania.raiseAngle(5);
        assertEquals(0, scania.getTruckBedAngle(),0.0);
    }
}
