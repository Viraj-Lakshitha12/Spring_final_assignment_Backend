package lk.ijse.gdse.UserService.service;


import lk.ijse.gdse.UserService.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity saveData(UserEntity user);

    List<UserEntity> getAllData();
}
