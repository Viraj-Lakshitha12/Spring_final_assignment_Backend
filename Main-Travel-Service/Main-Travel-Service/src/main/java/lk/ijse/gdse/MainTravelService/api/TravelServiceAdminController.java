package lk.ijse.gdse.MainTravelService.api;

import lk.ijse.gdse.MainTravelService.dto.TravelServiceDTO;
import lk.ijse.gdse.MainTravelService.entity.TravelService;
import lk.ijse.gdse.MainTravelService.service.MainTravelService;
import lk.ijse.gdse.MainTravelService.util.DataTypeConversion;
import lk.ijse.gdse.MainTravelService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class TravelServiceAdminController {
    @Autowired
    private final MainTravelService mainTravelService;
    @Autowired
    private final DataTypeConversion dataTypeConversion;


    public TravelServiceAdminController(MainTravelService service, DataTypeConversion conversion) {
        mainTravelService = service;
        dataTypeConversion = conversion;
    }

    @PostMapping("/login")  // Map to a specific endpoint for login
    public ResponseEntity<String> loginTravelServiceAdmin(
            @RequestParam String email,
            @RequestParam String password
    ) {
        // Check email and password for authentication
        if ("user".equals(email) && "123".equals(password)) {
            System.out.println(password);
            // Return a 200 OK response for successful login
            return ResponseEntity.status(HttpStatus.CREATED).body("login success");
        } else {
            // Return a 401 Unauthorized response for failed login
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

    @PostMapping(value = "/saveData", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveMainTravelDetails(@RequestBody TravelServiceDTO travelServiceDTO) {
        mainTravelService.saveData(dataTypeConversion.getTravelServiceEntity(travelServiceDTO));
        System.out.println(travelServiceDTO.getCategory());
        System.out.println(travelServiceDTO.getTotalAmount());
        System.out.println(travelServiceDTO.getUserId());
        System.out.println(travelServiceDTO.toString());
        return new ResponseUtil(201,"saved",null);
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<TravelService>> getAllDetails() {
        List<TravelService> details = mainTravelService.getAllDetails();
        // Check if the list is not empty before returning
        if (!details.isEmpty()) {
            return ResponseEntity.ok(details);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/findByUserID")
    public ResponseUtil findDetailsByUserID(@Param("userID") String userID){
        Optional<TravelService> details = mainTravelService.findDetailsByUserID(userID);
        if (details.isPresent()) {
            return new ResponseUtil(200, "saved",details );
        }else {
            return new ResponseUtil(200,"not found",null);
        }
    }
}
