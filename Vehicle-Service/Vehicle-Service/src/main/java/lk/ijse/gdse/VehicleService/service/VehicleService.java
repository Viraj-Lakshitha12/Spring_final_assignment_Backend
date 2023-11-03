package lk.ijse.gdse.VehicleService.service;

import lk.ijse.gdse.VehicleService.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    Vehicle saveData(Vehicle vehicle);

    List<Vehicle> getAllData();

    Optional<Vehicle> findById(Long id);
    void deleteVehicle(Long id);

    Vehicle updateVehicle(Vehicle vehicle);

}
