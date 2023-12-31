package lk.ijse.gdse.VehicleService.api;

import lk.ijse.gdse.VehicleService.dto.VehicleDTO;
import lk.ijse.gdse.VehicleService.entity.Vehicle;
import lk.ijse.gdse.VehicleService.service.VehicleService;
import lk.ijse.gdse.VehicleService.util.DataTypeConversion;
import lk.ijse.gdse.VehicleService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/vehicle")
public class VehicleServiceController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private DataTypeConversion dataTypeConversion;

    @PostMapping("/saveData")
    public ResponseUtil saveData(
            @RequestPart("vehicleDTO") VehicleDTO vehicleDTO,
            @RequestPart("frontViewImage") MultipartFile frontViewImage,
            @RequestPart("rearViewImage") MultipartFile rearViewImage,
            @RequestPart("sideViewImage") MultipartFile sideViewImage,
            @RequestPart("frontInteriorImage") MultipartFile frontInteriorImage,
            @RequestPart("rearInteriorImage") MultipartFile rearInteriorImage,
            @RequestPart("licenseFrontImage") MultipartFile licenseFrontImage,
            @RequestPart("licenseRearImage") MultipartFile licenseRearImage) {

        try {
            // Convert Multipart files to byte arrays
            byte[] frontViewImageBytes = frontViewImage.getBytes();
            byte[] rearViewImageBytes = rearViewImage.getBytes();
            byte[] sideViewImageBytes = sideViewImage.getBytes();
            byte[] frontInteriorImageBytes = frontInteriorImage.getBytes();
            byte[] rearInteriorImageBytes = rearInteriorImage.getBytes();
            byte[] licenseFrontImageBytes = licenseFrontImage.getBytes();
            byte[] licenseRearImageBytes = licenseRearImage.getBytes();

            // Set image bytes in the VehicleDTO
            vehicleDTO.setFrontViewImage(frontViewImageBytes);
            vehicleDTO.setRearViewImage(rearViewImageBytes);
            vehicleDTO.setSideViewImage(sideViewImageBytes);
            vehicleDTO.setFrontInteriorImage(frontInteriorImageBytes);
            vehicleDTO.setRearInteriorImage(rearInteriorImageBytes);
            vehicleDTO.setLicenseFrontImage(licenseFrontImageBytes);
            vehicleDTO.setLicenseRearImage(licenseRearImageBytes);

            // Convert the VehicleDTO to an entity and save it
            Vehicle vehicle = vehicleService.saveData(dataTypeConversion.getVehicleEntity(vehicleDTO));

            // Return a response indicating success
            return new ResponseUtil(201, "Vehicle data saved successfully", vehicle);
        } catch (IOException e) {
            // Handle file reading errors
            e.printStackTrace();
            return new ResponseUtil(500, "Error saving vehicle data: " + e.getMessage(), null);
        }
    }


    @GetMapping("/getAllData")
    public ResponseEntity<List<VehicleDTO>> getAllData() {
        List<Vehicle> vehicleData = vehicleService.getAllData();

        if (!vehicleData.isEmpty()) {
            // Convert Vehicle entities to VehicleDTOs
            List<VehicleDTO> vehicleDTOList = vehicleData.stream()
                    .map(vehicle -> dataTypeConversion.getVehicleDTO(vehicle))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(vehicleDTOList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/getData/{vehicleId}")
    public ResponseUtil getVehicleByVehicleId(@PathVariable Long vehicleId) {
        Optional<Vehicle> byId = vehicleService.findById(vehicleId);
        if (byId.isPresent()) {
            return new ResponseUtil(200,"found",byId);
        } else {
            return new ResponseUtil(500,"Internal Server Error",null);
        }
    }

    @DeleteMapping("/deleteVehicle/{vehicleId}")
    public ResponseUtil deleteVehicle(@PathVariable Long vehicleId){
        vehicleService.deleteVehicle(vehicleId);
        return new ResponseUtil(200,"Delete Success","null");
    }

    @PutMapping("/updateVehicle")
    public ResponseEntity<String> updateVehicle(@RequestPart("vehicleDTO") VehicleDTO vehicleDTO,
                                                @RequestPart("frontViewImage") MultipartFile frontViewImage,
                                                @RequestPart("rearViewImage") MultipartFile rearViewImage,
                                                @RequestPart("sideViewImage") MultipartFile sideViewImage,
                                                @RequestPart("frontInteriorImage") MultipartFile frontInteriorImage,
                                                @RequestPart("rearInteriorImage") MultipartFile rearInteriorImage,
                                                @RequestPart("licenseFrontImage") MultipartFile licenseFrontImage,
                                                @RequestPart("licenseRearImage") MultipartFile licenseRearImage){
        System.out.println(vehicleDTO);

        Vehicle vehicle = null;
        try {
            vehicle = vehicleService.updateVehicle(new Vehicle(vehicleDTO.getVehicleId(),vehicleDTO.getVehicleBrand(),vehicleDTO.getCategory(),
                    vehicleDTO.getFuelType(),vehicleDTO.getHybridOrNonHybrid(),vehicleDTO.getFuelUsage(),vehicleDTO.getSeatCapacity(),
                    vehicleDTO.getVehicleType(),vehicleDTO.getTransmissionType(),vehicleDTO.getVehicle_qty(),vehicleDTO.getDriverName(),vehicleDTO.getDriverContactNo(),
                    vehicleDTO.getVehicleFee(),vehicleDTO.getFee_For_1km(),vehicleDTO.getRemarks(),frontViewImage.getBytes(),rearViewImage.getBytes(),sideViewImage.getBytes(),
                    frontInteriorImage.getBytes(),rearInteriorImage.getBytes(),licenseFrontImage.getBytes(),licenseRearImage.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the vehicle");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Updated");
    }
}
