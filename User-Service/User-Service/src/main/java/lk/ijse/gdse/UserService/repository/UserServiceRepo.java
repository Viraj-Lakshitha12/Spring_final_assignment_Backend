package lk.ijse.gdse.UserService.repository;

import lk.ijse.gdse.UserService.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserServiceRepo extends JpaRepository<UserEntity,String> {
}
