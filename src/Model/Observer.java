package Model;

import Model.Vehicle.Vehicle;

import java.util.List;

public interface Observer {
    void modelUpdate(List<Vehicle> vehicles);

}
