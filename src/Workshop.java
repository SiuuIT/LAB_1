import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Cars> {
    private List<T> carsInWorkshop;
    private final int maxCapacity;

    public Workshop(int maxCapacity) {
        this.carsInWorkshop = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    private boolean isSpaceAvailable() {
        return carsInWorkshop.size() < maxCapacity;
    }

    public void receiveCar(T car) {
        if (isSpaceAvailable()) {
            carsInWorkshop.add(car);
            System.out.println(car.getModelName() + " received in the workshop.");
        } else {
            System.out.println("Workshop is full.");
        }
    }

    public T returnCar() {
        if (!carsInWorkshop.isEmpty()) {
            T returnedCar = carsInWorkshop.remove(carsInWorkshop.size() - 1);
            System.out.println(returnedCar.getModelName() + " returned from the workshop.");
            return returnedCar;
        } else {
            System.out.println("Workshop is empty.");
            return null;
        }
    }

    public static void main(String[] args) {
        Workshop<Volvo> volvoWorkshop = new Workshop<>(3);
        Workshop<Saab> saabWorkshop = new Workshop<>(2);

        volvoWorkshop.receiveCar(new Volvo());
        saabWorkshop.receiveCar(new Saab());

        Volvo returnedVolvo = volvoWorkshop.returnCar();
        Saab returnedSaab = saabWorkshop.returnCar();

        System.out.println("Returned Volvo: " + returnedVolvo);
        System.out.println("Returned Saab: " + returnedSaab);
    }
}
