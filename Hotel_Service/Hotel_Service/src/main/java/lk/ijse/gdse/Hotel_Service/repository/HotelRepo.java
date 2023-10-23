package lk.ijse.gdse.Hotel_Service.repository;

import lk.ijse.gdse.Hotel_Service.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,Long> {
}
