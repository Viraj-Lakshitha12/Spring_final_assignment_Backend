package lk.ijse.gdse.MainTravelService.service.impl;

import lk.ijse.gdse.MainTravelService.entity.TravelService;
import lk.ijse.gdse.MainTravelService.repository.TravelServiceRepo;
import lk.ijse.gdse.MainTravelService.service.MainTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TravelServiceImpl implements MainTravelService {
    @Autowired
    private TravelServiceRepo travelServiceRepo;

    @Override
    public TravelService saveData(TravelService travelService) {
       return travelServiceRepo.save(travelService);
    }

    @Override
    public List<TravelService> getAllDetails() {
        return travelServiceRepo.findAll();
    }

    @Override
    public Optional<TravelService> findDetailsByUserID(String userId) {
        return travelServiceRepo.findDetailsByUserID(userId);
    }

    @Override
    public TravelService updateDetails(TravelService travelService) {
    return travelServiceRepo.save(travelService);
    }
}
