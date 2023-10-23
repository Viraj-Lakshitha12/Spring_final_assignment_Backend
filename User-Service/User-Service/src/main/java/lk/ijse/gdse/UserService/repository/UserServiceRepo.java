package lk.ijse.gdse.UserService.repository;

import lk.ijse.gdse.UserService.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserServiceRepo extends JpaRepository<UserEntity,Long> {
}
