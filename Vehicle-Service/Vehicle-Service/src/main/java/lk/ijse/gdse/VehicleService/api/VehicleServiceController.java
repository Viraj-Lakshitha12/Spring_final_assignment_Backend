package lk.ijse.gdse.VehicleService.api;

import lk.ijse.gdse.VehicleService.dto.VehicleDTO;
import lk.ijse.gdse.VehicleService.entity.Vehicle;
import lk.ijse.gdse.VehicleService.service.VehicleService;
import lk.ijse.gdse.VehicleService.util.DataTypeConversion;
import lk.ijse.gdse.VehicleService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/vehicle")
public class VehicleServiceController {
    @Autowired
    private final VehicleService vehicleService;
    @Autowired
    private final DataTypeConversion dataTypeConversion;

    // Define the directory where uploaded images will be saved
    private static final String UPLOAD_DIRECTORY = "uploads";

    public VehicleServiceController(VehicleService service, DataTypeConversion conversion) {
        vehicleService = service;
        dataTypeConversion = conversion;
    }

    @PostMapping(value = "/saveData", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveData(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleService.saveData(dataTypeConversion.getVehicleEntity(vehicleDTO));
        System.out.println(vehicleDTO);
        return new ResponseUtil(201, "saved", vehicle);
    }

    @PostMapping(value = "/uploadImages", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseUtil uploadImages(@RequestParam("frontViewImage") MultipartFile frontViewImage,
                                     @RequestParam("rearViewImage") MultipartFile rearViewImage,
                                     @RequestParam("sideViewImage") MultipartFile sideViewImage,
                                     @RequestParam("frontInteriorImage") MultipartFile frontInteriorImage,
                                     @RequestParam("rearInteriorImage") MultipartFile rearInteriorImage,
                                     @RequestParam("licenseFrontImage") MultipartFile licenseFrontImage,
                                     @RequestParam("licenseRearImage") MultipartFile licenseRearImage) throws IOException {

        // Create the upload directory if it doesn't exist
        Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generate unique filenames for the uploaded images
        String frontViewFileName = UUID.randomUUID() + "_" + frontViewImage.getOriginalFilename();
        String rearViewFileName = UUID.randomUUID() + "_" + rearViewImage.getOriginalFilename();
        String sideViewFileName = UUID.randomUUID() + "_" + sideViewImage.getOriginalFilename();
        String frontInteriorFileName = UUID.randomUUID() + "_" + frontInteriorImage.getOriginalFilename();
        String rearInteriorFileName = UUID.randomUUID() + "_" + rearInteriorImage.getOriginalFilename();
        String licenseFrontFileName = UUID.randomUUID() + "_" + licenseFrontImage.getOriginalFilename();
        String licenseRearFileName = UUID.randomUUID() + "_" + licenseRearImage.getOriginalFilename();

        // Save the uploaded images to the upload directory
        frontViewImage.transferTo(uploadPath.resolve(frontViewFileName));
        rearViewImage.transferTo(uploadPath.resolve(rearViewFileName));
        sideViewImage.transferTo(uploadPath.resolve(sideViewFileName));
        frontInteriorImage.transferTo(uploadPath.resolve(frontInteriorFileName));
        rearInteriorImage.transferTo(uploadPath.resolve(rearInteriorFileName));
        licenseFrontImage.transferTo(uploadPath.resolve(licenseFrontFileName));
        licenseRearImage.transferTo(uploadPath.resolve(licenseRearFileName));

        return new ResponseUtil(201, "Images uploaded successfully", null);
    }
}
