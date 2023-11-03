package lk.ijse.gdse.Hotel_Service.service.impl;

import lk.ijse.gdse.Hotel_Service.entity.Hotel;
import lk.ijse.gdse.Hotel_Service.repository.HotelRepo;
import lk.ijse.gdse.Hotel_Service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceIMPL implements HotelService {

    @Autowired
    private final HotelRepo hotelRepo;


    public HotelServiceIMPL(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @Override
    public Hotel saveData(Hotel hotel) {
       return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllData() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    @Override
    public Optional<Hotel> findHotelById(Long hotelId) {
        return hotelRepo.findById(hotelId);
    }

    @Override
    public void deleteHotel(Long hotelId) {
        hotelRepo.deleteById(hotelId);
    }
}
