import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WorkshopTest {
    private Volvo volvo1;
    private Volvo volvo2;
    private Saab saab;

    private Workshop<Cars> workshop;
    private Workshop<Volvo> workshopVolvo;


    @Before
    public void init() {
        volvo1 = new Volvo();
        volvo2 = new Volvo();
        saab = new Saab();
        workshop = new Workshop<>(5);
        workshopVolvo = new Workshop<>(2);
    }

    @Test
    public void testReceiveCar() {
        //workshopVolvo.receiveCar(saab);
        assertTrue(workshopVolvo.isSpaceAvailable());
        workshopVolvo.receiveCar(volvo1);
        assertTrue(workshopVolvo.isSpaceAvailable());
        workshopVolvo.receiveCar(volvo2);
        assertFalse(workshopVolvo.isSpaceAvailable());
    }

    @Test
    public void testReturnCar() {

        workshop.receiveCar(saab);
        workshop.receiveCar(volvo2);

        assertEquals(volvo2, workshop.returnCar());
        assertEquals(saab, workshop.returnCar());
        assertNull(workshop.returnCar());
    }
}
