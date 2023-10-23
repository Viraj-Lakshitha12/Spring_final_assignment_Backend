package lk.ijse.gdse.VehicleService.service.impl;

import lk.ijse.gdse.VehicleService.entity.Vehicle;
import lk.ijse.gdse.VehicleService.repository.VehicleServiceRepo;
import lk.ijse.gdse.VehicleService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private final VehicleServiceRepo vehicleServiceRepo;

    public VehicleServiceImpl(VehicleServiceRepo repo) {
        vehicleServiceRepo = repo;
    }

    @Override
    public Vehicle saveData(Vehicle vehicle) {
        return vehicleServiceRepo.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllData() {
        return vehicleServiceRepo.findAll();
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return vehicleServiceRepo.findById(id);
    }
}
