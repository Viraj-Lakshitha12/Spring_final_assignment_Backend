package lk.ijse.gdse.UserService.service;

import lk.ijse.gdse.UserService.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserEntity saveData(UserEntity user);

    List<UserEntity> getAllData();

    Optional<UserEntity> getUserById(Long userId);

    UserEntity updateUser(UserEntity user);
    List<Long> getAllUserIds();


    UserEntity getUserByEmail(String email);

    void deleteUser(Long userId);
}
