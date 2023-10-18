package lk.ijse.gdse.UserService.service.impl;


import lk.ijse.gdse.UserService.entity.UserEntity;
import lk.ijse.gdse.UserService.repository.UserServiceRepo;
import lk.ijse.gdse.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserServiceRepo userServiceRepo;

    @Autowired
    public UserServiceImpl(UserServiceRepo userServiceRepo) {
        this.userServiceRepo = userServiceRepo;
    }

    @Override
    public UserEntity saveData(UserEntity user) {
        return userServiceRepo.save(user);
    }

    @Override
    public List<UserEntity> getAllData() {
        return userServiceRepo.findAll();
    }
}
