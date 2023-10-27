package lk.ijse.gdse.VehicleService.repository;

import lk.ijse.gdse.VehicleService.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleServiceRepo extends JpaRepository<Vehicle, Long> {
}
