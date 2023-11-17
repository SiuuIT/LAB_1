import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WorkshopTest {

    @Test
    public void testReceiveCar() {
        Workshop<Volvo> volvoWorkshop = new Workshop<>(5);
        Volvo volvo1 = new Volvo();
        Volvo volvo2 = new Volvo();

        assertTrue(volvoWorkshop.isSpaceAvailable());
        volvoWorkshop.receiveCar(volvo1);
        assertTrue(volvoWorkshop.isSpaceAvailable());
        volvoWorkshop.receiveCar(volvo2);
        assertFalse(volvoWorkshop.isSpaceAvailable());
    }

    @Test
    public void testReturnCar() {
        Workshop<Saab> saabWorkshop = new Workshop<>(5);
        Saab saab1 = new Saab();
        Saab saab2 = new Saab();

        saabWorkshop.receiveCar(saab1);
        saabWorkshop.receiveCar(saab2);

        assertEquals(saab2, saabWorkshop.returnCar());
        assertEquals(saab1, saabWorkshop.returnCar());
        assertNull(saabWorkshop.returnCar());
    }

    @Test
    public void testMixedWorkshop() {
        Workshop<Cars> mixedWorkshop = new Workshop<>(10);
        Saab saab = new Saab();
        Volvo volvo = new Volvo();

        mixedWorkshop.receiveCar(saab);
        mixedWorkshop.receiveCar(volvo);

        assertEquals(volvo, mixedWorkshop.returnCar());
        assertEquals(saab, mixedWorkshop.returnCar());
        assertNull(mixedWorkshop.returnCar());
    }

    @Test
    public void testInvalidReceive() {
        Workshop<Volvo> volvoWorkshop = new Workshop<>(2);
        Saab saab = new Saab();
        Scania scania = new Scania();

        //Ger error om man kommenterar bort
        //assertThrows(ClassCastException.class, () -> volvoWorkshop.receiveCar(saab));
        //assertThrows(ClassCastException.class, () -> volvoWorkshop.receiveCar(scania));
    }
}
