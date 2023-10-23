package lk.ijse.gdse.Hotel_Service.util;

import lk.ijse.gdse.Hotel_Service.dto.HotelDTO;
import lk.ijse.gdse.Hotel_Service.entity.Hotel;
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

    public HotelDTO getGuideDTO(Hotel hotel){
        return modelMapper.map(hotel, HotelDTO.class);
    }
    public Hotel getGuideEntity(HotelDTO hotelDTO){
        return modelMapper.map(hotelDTO, Hotel.class);
    }
}
