package lk.ijse.gdse.VehicleService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "vehicle_service")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vehicleId;
    private String vehicleBrand;
    private String category;
    private String fuelType;
    private String hybridOrNonHybrid;
    private String fuelUsage;
    private String seatCapacity;
    private String vehicleType;
    private String transmissionType;
    private String driverName;
    private String driverContactNo;
    private String remarks;
    @Column(length = 10485760)
    private byte[] frontViewImage;
    @Column(length = 10485760)
    private byte[] rearViewImage;
    @Column(length = 10485760)
    private byte[] sideViewImage;
    @Column(length = 10485760)
    private byte[] frontInteriorImage;
    @Column(length = 10485760)
    private byte[] rearInteriorImage;
    @Column(length = 10485760)
    private byte[] licenseFrontImage;
    @Column(length = 10485760)
    private byte[] licenseRearImage;
    }
