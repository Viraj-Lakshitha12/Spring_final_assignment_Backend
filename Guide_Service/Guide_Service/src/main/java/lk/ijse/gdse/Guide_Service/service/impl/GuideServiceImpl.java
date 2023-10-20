package lk.ijse.gdse.Guide_Service.service.impl;

import lk.ijse.gdse.Guide_Service.entity.Guide;
import lk.ijse.gdse.Guide_Service.repository.GuiderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuideServiceImpl implements GuideService {
    @Autowired
    private final GuiderRepo guiderRepo;

    public GuideServiceImpl(GuiderRepo repo) {
        guiderRepo = repo;
    }

    @Override
    public Guide saveData(Guide guide) {
        return guiderRepo.save(guide);
    }
}
