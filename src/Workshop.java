import java.util.ArrayList;
import java.util.List;

public class Workshop<T> {
    private List<T> cars;
    private final int maxCapacity;

    public Workshop(int maxCapacity) {
        this.cars = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    public void acceptCar(T car) {
        if (isSpaceAvailable()) {
            cars.add(car);
            System.out.println(car.getClass().getSimpleName() + " accepted in the workshop.");
        } else {
            System.out.println("Workshop is full.");
        }
    }

    private boolean isSpaceAvailable() {
        return cars.size() < maxCapacity;
    }

    public T releaseCar() {
        if (!cars.isEmpty()) {
            T releasedCar = cars.remove(cars.size() - 1);
            System.out.println(releasedCar.getClass().getSimpleName() + " released from the workshop.");
            return releasedCar;
        } else {
            System.out.println("Workshop is empty.");
            return null;
        }
    }

    public static void main(String[] args) {
        Workshop<Scania> scaniaWorkshop = new Workshop<>(3);
        Workshop<CarTransport> transportWorkshop = new Workshop<>(2);

        scaniaWorkshop.acceptCar(new Scania());
        transportWorkshop.acceptCar(new CarTransport());

        Scania releasedScania = scaniaWorkshop.releaseCar();
        CarTransport releasedTransport = transportWorkshop.releaseCar();

        System.out.println("Released Scania: " + releasedScania);
        System.out.println("Released CarTransport: " + releasedTransport);
    }
}
