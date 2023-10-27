package lk.ijse.gdse.UserService.api;

import lk.ijse.gdse.UserService.dto.UserDTO;
import lk.ijse.gdse.UserService.entity.UserEntity;
import lk.ijse.gdse.UserService.service.UserService;
import lk.ijse.gdse.UserService.util.DataTypeConversion;
import lk.ijse.gdse.UserService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin("*")
@Validated
public class UserServiceController {

    private final UserService userService;
    private final DataTypeConversion dataTypeConversion;

    @Autowired
    public UserServiceController(UserService userService, DataTypeConversion dataTypeConversion) {
        this.userService = userService;
        this.dataTypeConversion = dataTypeConversion;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginTravelServiceAdmin(
            @RequestParam String email,
            @RequestParam String password
    ) {
        // Implement authentication logic here, check user credentials in the database
        // Example: If (userService.authenticateUser(email, password)) { ... }

        // Replace the example logic above with your authentication logic

        // If authentication is successful, return 200 OK
        return ResponseEntity.status(HttpStatus.OK).body("Login success");

        // If authentication fails, return 401 Unauthorized
        // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
    }

    @PostMapping(value = "/saveData" ,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> saveMainTravelDetails(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO.toString());
        UserEntity user = userService.saveData(dataTypeConversion.getUserEntity(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseUtil(201, "User data saved", user));

        // If the save operation fails, return an appropriate response
        // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseUtil(500, "User data not saved", null));
    }
    @GetMapping("/getAllData")
    public ResponseEntity<List<UserDTO>> getAllDetails() {
        List<UserEntity> userData = userService.getAllData();

        if (!userData.isEmpty()) {
            // Convert User entities to UserDTOs
            List<UserDTO> userDTOList = userData.stream().map(dataTypeConversion::getUserDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(userDTOList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/getUserData/{userId}")
    public ResponseEntity<?> getGuideDetailsById(@PathVariable Long userId) {
        Optional<UserEntity> guideById = userService.getGuideById(userId);
        if (guideById.isPresent()) {
            return ResponseEntity.ok(guideById.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User not found");
        }
    }


    @PostMapping("/updateUserData")
    public ResponseEntity<String> updateGuideDetails(
                @RequestParam("user_Image_front_side") MultipartFile frontImage,
                @RequestParam("user_Image_back_side") MultipartFile backImage,
                @RequestParam("user_id") Long userId,
                @RequestParam("user_nic") String userNic,
                @RequestParam("gender") String gender,
                @RequestParam("user_email") String userEmail,
                @RequestParam("contact") String contact,
                @RequestParam("user_age") int userAge,
                @RequestParam("user_address") String userAddress,
                @RequestParam("user_remarks") String userRemarks) {

            try {
                UserEntity userEntity = userService.updateUser(new UserEntity(userId, userNic, frontImage.getBytes(), backImage.getBytes(), gender, userEmail, contact, userAge,
                        userAddress, userRemarks));

                return ResponseEntity.ok("User data updated successfully");
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the user");
            }
    }

    @GetMapping("/getAllUserIds")
    public List<Long> getAllUserIds(){
        return userService.getAllUserIds();
    }
}

