package lk.ijse.gdse.VehicleService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {
    private long vehicleId;
    private String vehicleBrand;
    private String category;
    private String fuelType;
    private String hybridOrNonHybrid;
    private String fuelUsage;
    private String seatCapacity;
    private String vehicleType;
    private String transmissionType;
    private String vehicle_qty;
    private String driverName;
    private String driverContactNo;
    private String vehicleFee;
    private String fee_For_1km;
    private String remarks;

    private byte[] frontViewImage;
    private byte[] rearViewImage;
    private byte[] sideViewImage;
    private byte[] frontInteriorImage;
    private byte[] rearInteriorImage;
    private byte[] licenseFrontImage;
    private byte[] licenseRearImage;
}
