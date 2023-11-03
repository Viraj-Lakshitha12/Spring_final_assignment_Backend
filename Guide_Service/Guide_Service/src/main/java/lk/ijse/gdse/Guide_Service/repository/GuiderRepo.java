package lk.ijse.gdse.Guide_Service.repository;

import lk.ijse.gdse.Guide_Service.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuiderRepo extends JpaRepository<Guide,Long> {
    Optional<Guide> findByContactNumber(String contactNumber);
}
