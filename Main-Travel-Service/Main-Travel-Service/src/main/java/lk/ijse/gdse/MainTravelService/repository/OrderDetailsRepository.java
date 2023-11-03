package lk.ijse.gdse.MainTravelService.repository;

import jakarta.persistence.criteria.Order;
import lk.ijse.gdse.MainTravelService.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    // You can add custom query methods if needed
}
