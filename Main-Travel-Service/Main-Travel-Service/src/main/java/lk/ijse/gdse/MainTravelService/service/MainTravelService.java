package lk.ijse.gdse.MainTravelService.service;

import lk.ijse.gdse.MainTravelService.entity.TravelService;

import java.util.List;
import java.util.Optional;

public interface MainTravelService {

    TravelService saveData(TravelService travelService);

    List<TravelService> getAllDetails();

    Optional<TravelService> findDetailsByUserID(String userId);
}
