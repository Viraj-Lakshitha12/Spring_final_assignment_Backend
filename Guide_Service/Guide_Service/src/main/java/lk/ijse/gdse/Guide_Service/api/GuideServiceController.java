package lk.ijse.gdse.Guide_Service.api;

import lk.ijse.gdse.Guide_Service.dto.GuideDTO;
import lk.ijse.gdse.Guide_Service.entity.Guide;
import lk.ijse.gdse.Guide_Service.service.impl.GuideService;
import lk.ijse.gdse.Guide_Service.util.DataTypeConversion;
import lk.ijse.gdse.Guide_Service.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/guide")
public class GuideServiceController {

    private final GuideService guideService;
    private final DataTypeConversion dataTypeConversion;

    @Autowired
    public GuideServiceController(GuideService guideService, DataTypeConversion dataTypeConversion) {
        this.guideService = guideService;
        this.dataTypeConversion = dataTypeConversion;
    }

    @PostMapping("/saveGuide")
    public ResponseUtil saveGuide(
            @RequestParam("Guide_Name") String guideName,
            @RequestParam("Guide_Address") String guideAddress,
            @RequestParam("Guide_Age") String guideAge,
            @RequestParam("gender") String gender,
            @RequestParam("Contact_number") String contactNumber,
            @RequestParam("Man-day-value") int manDayValue,
            @RequestPart("Guide_image") MultipartFile guideImage,
            @RequestPart("Guide_Nic_font") MultipartFile guideNicFront,
            @RequestPart("Guide_Nic_Rear") MultipartFile guideNicRear,
            @RequestPart("Guide_ID_font") MultipartFile guideIdFront,
            @RequestPart("Guide_ID_Rear") MultipartFile guideIdRear,
            @RequestParam("guide_experience") String experience,
            @RequestParam("User_remarks") String userRemarks
    ) {
        try {
            byte[] guideImageBytes = guideImage.getBytes();
            byte[] nicFrontImageBytes = guideNicFront.getBytes();
            byte[] nicRearImageBytes = guideNicRear.getBytes();
            byte[] guideIdFrontBytes = guideIdFront.getBytes();
            byte[] guideIdRearBytes = guideIdRear.getBytes();

            // You can perform data validation here

            GuideDTO dto = new GuideDTO(null, guideName, guideAddress, guideAge, gender, contactNumber, manDayValue, experience, userRemarks,
                    guideImageBytes, nicFrontImageBytes, nicRearImageBytes, guideIdFrontBytes, guideIdRearBytes);

            Guide guide = guideService.saveData(dataTypeConversion.getGuideEntity(dto));

            return new ResponseUtil(201, "Guide data saved successfully", guide);
        } catch (IOException e) {
            return new ResponseUtil(500, "Error converting image to byte array: " + e.getMessage(), null);
        }
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<Guide>> getAllDetails() {
        List<Guide> details = guideService.getAllData();
        return !details.isEmpty() ? ResponseEntity.ok(details) : ResponseEntity.noContent().build();
    }

    @GetMapping("/getGuideById/{id}")
    public ResponseEntity<?> getGuideDetailsById(@PathVariable Long id) {
        Optional<Guide> guideById = guideService.getGuideById(id);
        if (guideById.isPresent()) {
            return ResponseEntity.ok(guideById.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Guide not found");
        }
    }

    @PutMapping("/updateGuide/{guideId}")
    public ResponseEntity<ResponseUtil> updateGuideDetails(@PathVariable Long guideId, @RequestBody Guide updatedGuide) {
        Guide guide = guideService.updateGuide(updatedGuide);

        if (guide != null) {
//            System.out.println(guide);
            return ResponseEntity.ok(new ResponseUtil(201,"Guide details updated successfully", guide));
        } else {
            // Handle the case where the update operation fails
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil(500,"Failed to update guide details", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }
}
