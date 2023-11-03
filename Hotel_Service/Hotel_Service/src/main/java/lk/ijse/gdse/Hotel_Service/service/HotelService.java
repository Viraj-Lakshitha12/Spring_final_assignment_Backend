package lk.ijse.gdse.Hotel_Service.service;

import lk.ijse.gdse.Hotel_Service.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    Hotel saveData(Hotel hotel);

    List<Hotel> getAllData();

    Hotel updateHotel(Hotel hotel);

    Optional<Hotel> findHotelById(Long hotelId);

    void deleteHotel(Long hotelId);
}
