package lk.ijse.gdse.Guide_Service.repository;

import lk.ijse.gdse.Guide_Service.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuiderRepo extends JpaRepository<Guide,Long> {
}
