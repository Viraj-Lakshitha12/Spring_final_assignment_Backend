package lk.ijse.gdse.UserService.service;

import lk.ijse.gdse.UserService.entity.RegisterUser;
import lk.ijse.gdse.UserService.service.impl.RegisterUserServiceImpl;

public interface RegisterUserService {
    RegisterUser saveRegisterUser(RegisterUser registerUser);
}
