package lk.ijse.gdse.Guide_Service.api;

import lk.ijse.gdse.Guide_Service.dto.GuideDTO;
import lk.ijse.gdse.Guide_Service.entity.Guide;
import lk.ijse.gdse.Guide_Service.service.impl.GuideService;
import lk.ijse.gdse.Guide_Service.util.DataTypeConversion;
import lk.ijse.gdse.Guide_Service.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/guide")
public class GuideServiceController {

    @Autowired
    private GuideService guideService;
    @Autowired
    private DataTypeConversion dataTypeConversion;

    @PostMapping("/saveGuide")
    public ResponseUtil saveGuide(
            @RequestParam("Guide_Name") String guideName,
            @RequestParam("Guide_Address") String guideAddress,
            @RequestParam("Guide_Age") String guideAge,
            @RequestParam("gender") String gender,
            @RequestParam("Contact_number") String contactNumber,
            @RequestParam("Man-day-value") int manDayValue,
            @RequestPart("Guide_image") MultipartFile guideImage
//            @RequestPart("Guide_Nic_font") MultipartFile guideNicFront,
//            @RequestPart("Guide_Nic_Rear") MultipartFile guideNicRear,
//            @RequestPart("Guide_ID_font") MultipartFile guideIdFront,
//            @RequestPart("Guide_ID_Rear") MultipartFile guideIdRear,
//            @RequestParam("Experience") String experience,
//            @RequestParam("User_remarks") String userRemarks
    ) {

//            byte[] nicFrontImageBytes = guideNicFront.getBytes();
//            byte[] nicRearImageBytes = guideNicRear.getBytes();
//            byte[] guideIdFrontBytes = guideIdFront.getBytes();
//            byte[] guideIdRearBytes = guideIdRear.getBytes();

            // Data validation can be added here, e.g., checking age and other parameters

            // Save guide data to the database using guideService
//            GuideDTO dto = new GuideDTO(null, guideName, guideAddress, guideAge, gender, contactNumber, manDayValue, experience, userRemarks,
//                    guideImageBytes, nicFrontImageBytes, nicRearImageBytes, guideIdFrontBytes, guideIdRearBytes);

            try {
                // Convert MultipartFile image to a byte array
                byte[] guideImageBytes = guideImage.getBytes();

                // Data validation can be added here, e.g., checking age and other parameters

                // Save guide data to the database using guideService
                GuideDTO dto = new GuideDTO(guideName, guideAddress, guideAge, gender, contactNumber, manDayValue, guideImageBytes);

                Guide guide = guideService.saveData(dataTypeConversion.getGuideEntity(dto));

                // Convert the saved entity back to DTO
                GuideDTO savedDto = dataTypeConversion.getGuideDTO(guide);

                // Return a response with the saved guide data
                return new ResponseUtil(201, "Guide data saved successfully", savedDto);
            } catch (IOException e) {
                return new ResponseUtil(500, "Error converting image to byte array: " + e.getMessage(), null);
            }
        }
    }