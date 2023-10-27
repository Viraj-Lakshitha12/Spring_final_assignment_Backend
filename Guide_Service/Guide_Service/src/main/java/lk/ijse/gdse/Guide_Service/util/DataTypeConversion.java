package lk.ijse.gdse.Guide_Service.util;

import lk.ijse.gdse.Guide_Service.dto.GuideDTO;
import lk.ijse.gdse.Guide_Service.entity.Guide;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataTypeConversion {

    private final ModelMapper modelMapper;

    @Autowired
    public DataTypeConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GuideDTO getGuideDTO(Guide guide){
        return modelMapper.map(guide, GuideDTO.class);
    }
    public Guide getGuideEntity(GuideDTO guideDTO){
        return modelMapper.map(guideDTO, Guide.class);
    }
}
