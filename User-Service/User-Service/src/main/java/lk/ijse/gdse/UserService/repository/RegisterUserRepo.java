package lk.ijse.gdse.UserService.repository;

import lk.ijse.gdse.UserService.entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterUserRepo extends JpaRepository<RegisterUser,Long> {
}
