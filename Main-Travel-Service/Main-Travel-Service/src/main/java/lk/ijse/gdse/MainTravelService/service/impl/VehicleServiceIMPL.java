package lk.ijse.gdse.MainTravelService.service.impl;

import lk.ijse.gdse.MainTravelService.entity.Vehicle;
import lk.ijse.gdse.MainTravelService.repository.VehicleRepo;
import lk.ijse.gdse.MainTravelService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceIMPL implements VehicleService {
    @Autowired
    private final VehicleRepo vehicleRepo;

    public VehicleServiceIMPL(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

}
