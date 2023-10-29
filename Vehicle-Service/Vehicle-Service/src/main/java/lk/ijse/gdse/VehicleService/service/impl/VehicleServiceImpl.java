package lk.ijse.gdse.VehicleService.service.impl;

import lk.ijse.gdse.VehicleService.entity.Vehicle;
import lk.ijse.gdse.VehicleService.repository.VehicleServiceRepo;
import lk.ijse.gdse.VehicleService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
    @Override
    public Vehicle updateUser(Vehicle vehicleEntity) {
        Optional<Vehicle> optionalVehicle = vehicleServiceRepo.findById(vehicleEntity.getVehicleId());
        if (optionalVehicle.isPresent()){
            Vehicle existsVehicle = optionalVehicle.get();
            existsVehicle.setVehicleBrand(vehicleEntity.getVehicleBrand());
            existsVehicle.setCategory(vehicleEntity.getCategory());
            existsVehicle.setFuelType(vehicleEntity.getFuelType());
            existsVehicle.setHybridOrNonHybrid(vehicleEntity.getHybridOrNonHybrid());
            existsVehicle.setFuelUsage(vehicleEntity.getFuelUsage());
            existsVehicle.setSeatCapacity(vehicleEntity.getSeatCapacity());
            existsVehicle.setVehicleType(vehicleEntity.getVehicleType());
            existsVehicle.setVehicleType(vehicleEntity.getVehicleType());
            existsVehicle.setTransmissionType(vehicleEntity.getTransmissionType());
            existsVehicle.setDriverName(vehicleEntity.getDriverName());
            existsVehicle.setDriverContactNo(vehicleEntity.getDriverContactNo());
            existsVehicle.setRemarks(vehicleEntity.getRemarks());
            existsVehicle.setFrontViewImage(vehicleEntity.getFrontViewImage());
            existsVehicle.setRearViewImage(vehicleEntity.getRearViewImage());
            existsVehicle.setSideViewImage(vehicleEntity.getSideViewImage());
            existsVehicle.setFrontInteriorImage(vehicleEntity.getFrontInteriorImage());
            existsVehicle.setRearInteriorImage(vehicleEntity.getRearInteriorImage());
            existsVehicle.setLicenseFrontImage(vehicleEntity.getLicenseFrontImage());
            existsVehicle.setLicenseRearImage(vehicleEntity.getLicenseRearImage());

            return vehicleServiceRepo.save(existsVehicle);
        }
        throw new NoSuchElementException("Vehicle not found with ID: " + vehicleEntity.getVehicleId());
    }

}
