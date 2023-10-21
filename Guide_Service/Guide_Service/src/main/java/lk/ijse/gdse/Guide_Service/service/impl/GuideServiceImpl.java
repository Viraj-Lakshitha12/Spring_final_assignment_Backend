package lk.ijse.gdse.Guide_Service.service.impl;

import lk.ijse.gdse.Guide_Service.entity.Guide;
import lk.ijse.gdse.Guide_Service.repository.GuiderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Guide> getAllData() {
        return guiderRepo.findAll();
    }

    @Override
    public Optional<Guide> getGuideById(Long id) {
        return guiderRepo.findById(id);
    }

    @Override
    public Guide updateGuide(Guide guide) {
        return guiderRepo.save(guide);
    }
}
