package lk.ijse.gdse.UserService.repository;

import lk.ijse.gdse.UserService.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserServiceRepo extends JpaRepository<UserEntity,Long> {
    @Query("SELECT u FROM UserEntity u WHERE u.user_email = :email")
    UserEntity findByUserEmail(@Param("email") String email);

    @Query("SELECT user.user_id FROM UserEntity user")
    List<Long> getAllUserIds();
}
