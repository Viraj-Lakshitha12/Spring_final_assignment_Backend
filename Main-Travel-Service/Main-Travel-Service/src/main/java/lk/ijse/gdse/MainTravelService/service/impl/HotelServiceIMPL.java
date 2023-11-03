package lk.ijse.gdse.MainTravelService.service.impl;

import lk.ijse.gdse.MainTravelService.entity.Hotel;
import lk.ijse.gdse.MainTravelService.repository.HotelRepo;
import lk.ijse.gdse.MainTravelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceIMPL implements HotelService {
    @Autowired
    private final HotelRepo hotelRepo;

    public HotelServiceIMPL(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }
}
