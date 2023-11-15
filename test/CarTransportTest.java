import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class CarTransportTest {
    private CarTransport carTransport;

    @Before
    public void init() {
        carTransport = new CarTransport();
    }

    @Test
    public void checkIfRampCanBeLoweredWhenSpeedIsNot0() {
        carTransport.gas(100);
        carTransport.lowerRamp();
        assertFalse(carTransport.getRamp());
    }
    @Test
    public void checkIfCarCanStartWhenRampIsLowered(){
        carTransport.lowerRamp();
        carTransport.startEngine();
        carTransport.gas(100);
        assertEquals(0, carTransport.getCurrentSpeed(), 0.0);
    }
}

