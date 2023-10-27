package lk.ijse.gdse.UserService.api;

import lk.ijse.gdse.UserService.dto.RegisterUserDTO;
import lk.ijse.gdse.UserService.entity.RegisterUser;
import lk.ijse.gdse.UserService.service.RegisterUserService;
import lk.ijse.gdse.UserService.util.DataTypeConversion;
import lk.ijse.gdse.UserService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/registerUser")
@CrossOrigin("*")
@Validated
public class RegisterUserController {
    @Autowired
    private final RegisterUserService registerUserService;
    @Autowired
    private final DataTypeConversion dataTypeConversion;

    public RegisterUserController(RegisterUserService registerUserService, DataTypeConversion dataTypeConversion) {
        this.registerUserService = registerUserService;
        this.dataTypeConversion = dataTypeConversion;
    }

    @PostMapping("/saveData")
    public ResponseUtil saveRegisterUserData(@RequestBody RegisterUserDTO registerUserDTO){
        RegisterUser registerUser = registerUserService.saveRegisterUser(dataTypeConversion.getRegisterUserEntity(registerUserDTO));
        System.out.println(registerUserDTO);
        return new ResponseUtil(201,"saved",registerUser);
    }

}
