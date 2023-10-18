package lk.ijse.gdse.MainTravelService.repository;

import lk.ijse.gdse.MainTravelService.entity.TravelService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface TravelServiceRepo extends JpaRepository<TravelService, String> {
    @Query("SELECT t FROM TravelService t WHERE t.userId = :userId")
    Optional<TravelService> findDetailsByUserID(@Param("userId") String userId);
}
