package lk.ijse.gdse.UserService.service.impl;

import lk.ijse.gdse.UserService.entity.RegisterUser;
import lk.ijse.gdse.UserService.repository.RegisterUserRepo;
import lk.ijse.gdse.UserService.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

    @Autowired
    private final RegisterUserRepo registerUserRepo;

    public RegisterUserServiceImpl(RegisterUserRepo registerUserRepo) {
        this.registerUserRepo = registerUserRepo;
    }

    @Override
    public RegisterUser saveRegisterUser(RegisterUser registerUser) {
        return registerUserRepo.save(registerUser);
    }
}
