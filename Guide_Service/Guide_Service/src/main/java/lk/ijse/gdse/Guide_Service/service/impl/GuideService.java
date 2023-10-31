package lk.ijse.gdse.Guide_Service.service.impl;

import lk.ijse.gdse.Guide_Service.entity.Guide;

import java.util.List;
import java.util.Optional;

public interface GuideService {
    Guide saveData(Guide guide);

    List<Guide> getAllData();

    Optional<Guide> getGuideById(Long id);

    Guide updateGuide(Guide guide);

    void deleteGuideById(Long guideId);
}
