package lk.ijse.gdse.UserService.repository;

import lk.ijse.gdse.UserService.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface AdminRepo extends JpaRepository<Admin,String> {
    Admin findAdminByEmail(String email);
}
