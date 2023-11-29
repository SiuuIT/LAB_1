import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class CarTransportTest {
    private CarTransport carTransport;
    private Volvo volvo;
    private Ramp ramp;

    @Before
    public void init() {
        carTransport = new CarTransport();
        volvo = new Volvo();
    }
    @Test
    public void checkIfRampCantBeLoweredWhenSpeedIsNot0() {
        carTransport.raiseRamp();
        carTransport.startEngine();
        carTransport.gas(100);
        carTransport.lowerRamp();
        assertTrue(carTransport.getRamp());
    }
    @Test
    public void checkIfCarCanStartWhenRampIsLowered(){
        carTransport.lowerRamp();
        carTransport.startEngine();
        carTransport.gas(100);
        assertEquals(0, carTransport.getCurrentSpeed(), 0.0);
    }
    @Test
    public void checkIfRampCanBeRaisedWhenStill(){
    carTransport.lowerRamp();
    carTransport.raiseRamp();
    assertTrue(carTransport.getRamp());
    }
    @Test
    public void testProximity(){
        volvo.startEngine();
        volvo.move();
        assertTrue(carTransport.checkProximity(volvo));
        volvo.currentSpeed = 50;
        volvo.move();
        assertFalse(carTransport.checkProximity(volvo));

    }
    @Test
    public void testLoad(){
        carTransport.lowerRamp();
        carTransport.load(volvo);
        assertTrue(carTransport.carList.contains(volvo));
    }
    @Test
    public void testUnload(){
        carTransport.lowerRamp();
        carTransport.load(volvo);
        carTransport.unload(volvo);
        assertFalse(carTransport.carList.contains(volvo));

    }
    @Test
    public void testGetLoadedCars(){
        carTransport.lowerRamp();
        carTransport.load(volvo);
        assertEquals(carTransport.carList, carTransport.getLoadedCars());

    }
    @Test
    public void testIfAllCoordinatesChange(){
        carTransport.lowerRamp();
        carTransport.load(volvo);
        carTransport.raiseRamp();
        carTransport.startEngine();
        carTransport.move();
        assertEquals(0.1, carTransport.y_coordinate,0.0);
        assertEquals(0.1, volvo.y_coordinate,0.0);
        assertEquals(0.0, volvo.x_coordinate,0.0);
        assertEquals(0.0, carTransport.x_coordinate,0.0);
    }
}
