package lk.ijse.gdse.UserService.api;

import lk.ijse.gdse.UserService.entity.Admin;
import lk.ijse.gdse.UserService.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> checkEmailAndPassword(@RequestParam String email,
                                                        @RequestParam String password
    ){
        Admin adminByEmail = adminService.getAdminByEmail(email);

        if (adminByEmail.getEmail() != null) {
            // User with the provided email exists
            if (adminByEmail.getPassword().equals(password)) {
                if (adminByEmail.getRole().equals("vehicleAdmin")){
                    return ResponseEntity.status(HttpStatus.OK).body("vehicleAdmin Login success");
                }else if(adminByEmail.getRole().equals("userAdmin")){
                    return ResponseEntity.status(HttpStatus.OK).body("userAdmin Login success");
                }else if(adminByEmail.getRole().equals("guideAdmin")){
                    return ResponseEntity.status(HttpStatus.OK).body("guideAdmin Login success");
                }else if(adminByEmail.getRole().equals("hotelAdmin")){
                    return ResponseEntity.status(HttpStatus.OK).body("hotelAdmin Login success");
                }else if(adminByEmail.getRole().equals("travelAdmin")){
                    return ResponseEntity.status(HttpStatus.OK).body("travelAdmin Login success");
                }
                return null;

            } else {System.out.println("log Not");

                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: Incorrect password");
            }
        } else {
            // User with the provided email does not exist
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: User not found");
        }
    }
}
