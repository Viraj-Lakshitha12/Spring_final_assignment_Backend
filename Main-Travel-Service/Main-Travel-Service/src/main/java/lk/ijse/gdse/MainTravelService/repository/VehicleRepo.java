package lk.ijse.gdse.MainTravelService.repository;

import lk.ijse.gdse.MainTravelService.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,Long> {
}
