package Container.Workshop;
import Model.Vehicle.Vehicle;

public class Workshop <T extends Vehicle>{

    public Model.Container.Container<T> container; //private

    public Workshop(){
        this.container = new Model.Container.Container<>(10);
    }
    public void loadCarinWorkshop(T vehicle ){
        container.loadN(vehicle);
    }
    public void unloadCarinWorkshop(T vehicle ){
        T v =  container.unloadN(vehicle);
    }

    public boolean containerIsEmpty() {
        container.contains();
        return container.contains();
    }




}
