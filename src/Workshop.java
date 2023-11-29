import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Cars> {
    private List<T> cars;
    private final int maxCapacity;

    public Workshop(int maxCapacity) {
        this.cars = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    private boolean isSpaceAvailable() {
        return cars.size() < maxCapacity;
    }

    public void acceptCarTransport(CarTransport carTransport) {
        List<Cars> loadedCars = carTransport.getLoadedCars();
        for (Cars loadedCar : loadedCars) {
            if (isSpaceAvailable()) {
                cars.add((T) loadedCar);
                System.out.println(loadedCar.getModelName() + " accepted in the workshop.");
            } else {
                System.out.println("Workshop is full.");
                break;
            }
        }
    }

    public T releaseCar() {
        if (!cars.isEmpty()) {
            T releasedCar = cars.remove(cars.size() - 1);
            System.out.println(releasedCar.getModelName() + " released from the workshop.");
            return releasedCar;
        } else {
            System.out.println("Workshop is empty.");
            return null;
        }
    }
    public static void main(String[] args) {
        Workshop<Volvo> volvoWorkshop = new Workshop<>(3);
        Workshop<Saab> saabWorkshop = new Workshop<>(2);

        CarTransport carTransport = new CarTransport();
        carTransport.lowerRamp();
        carTransport.lassa(new Volvo());
        carTransport.lassa(new Saab());
        volvoWorkshop.acceptCarTransport(carTransport);

        Volvo releasedVolvo = volvoWorkshop.releaseCar();
        System.out.println("Released Volvo: " + releasedVolvo);

        Saab releasedSaab = saabWorkshop.releaseCar();
        System.out.println("Released Saab: " + releasedSaab);
    }
}
