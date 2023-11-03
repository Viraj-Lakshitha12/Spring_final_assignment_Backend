package lk.ijse.gdse.MainTravelService.service.impl;

import lk.ijse.gdse.MainTravelService.entity.Guide;
import lk.ijse.gdse.MainTravelService.repository.GuideRepo;
import lk.ijse.gdse.MainTravelService.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuideServiceIMPL implements GuideService {
    @Autowired
    private final GuideRepo guideRepo;

    public GuideServiceIMPL(GuideRepo guideRepo) {
        this.guideRepo = guideRepo;
    }

    @Override
    public Guide saveGuide(Guide guide) {
        return guideRepo.save(guide);
    }

}
