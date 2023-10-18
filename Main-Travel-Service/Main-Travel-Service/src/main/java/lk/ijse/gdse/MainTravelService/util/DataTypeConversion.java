package lk.ijse.gdse.MainTravelService.util;

import lk.ijse.gdse.MainTravelService.dto.TravelServiceDTO;
import lk.ijse.gdse.MainTravelService.entity.TravelService;
import lk.ijse.gdse.MainTravelService.service.MainTravelService;
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

    public TravelServiceDTO getTravelServiceDTO(MainTravelService mainTravelService){
        return modelMapper.map(mainTravelService, TravelServiceDTO.class);
    }
    public TravelService getTravelServiceEntity(TravelServiceDTO travelServiceDTO){
        return modelMapper.map(travelServiceDTO, TravelService.class);
    }
}
