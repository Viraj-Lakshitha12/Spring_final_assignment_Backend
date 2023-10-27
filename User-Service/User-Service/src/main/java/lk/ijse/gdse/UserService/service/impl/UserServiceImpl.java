package lk.ijse.gdse.UserService.service.impl;

import lk.ijse.gdse.UserService.entity.UserEntity;
import lk.ijse.gdse.UserService.repository.UserServiceRepo;
import lk.ijse.gdse.UserService.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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


    @Override
    public Optional<UserEntity> getUserById(Long userId) {
        return userServiceRepo.findById(userId);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        Optional<UserEntity> optionalUser = userServiceRepo.findById(user.getUser_id());

        if (optionalUser.isPresent()) {
            UserEntity existingUser = optionalUser.get();
            existingUser.setUser_Password(user.getUser_Password());
            existingUser.setUserName(user.getUserName());
            existingUser.setUser_id(user.getUser_id());
            existingUser.setUser_nic(user.getUser_nic());
            existingUser.setFrontSideImage(user.getFrontSideImage());
            existingUser.setBackSideImage(user.getBackSideImage());
            existingUser.setGender(user.getGender());
            existingUser.setUser_email(user.getUser_email());
            existingUser.setContact(user.getContact());
            existingUser.setUser_age(user.getUser_age());
            existingUser.setUser_address(user.getUser_address());
            existingUser.setUser_remarks(user.getUser_remarks());

            // Save the updated user
            return userServiceRepo.save(existingUser);
        } else {
            // Handle the case where the user is not found
            // You can return an appropriate response or throw an exception
            throw new NoSuchElementException("User not found with ID: " + user.getUser_id());
        }
    }

    @Override
    public List<Long> getAllUserIds() {
        return userServiceRepo.getAllUserIds();
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return userServiceRepo.findByUserEmail(email);
    }


}
