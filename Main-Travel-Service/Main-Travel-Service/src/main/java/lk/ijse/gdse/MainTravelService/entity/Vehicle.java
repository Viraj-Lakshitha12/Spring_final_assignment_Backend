package lk.ijse.gdse.MainTravelService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Vehicle {
    @Id
    private long vehicleId;
    private String vehicleBrand;
    private String vehicleType;
    private String driverName;
    private String driverContactNo;

}
