package lk.ijse.gdse.Hotel_Service.service;

import lk.ijse.gdse.Hotel_Service.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel saveData(Hotel hotel);

    List<Hotel> getAllData();

    Hotel updateHotel(Hotel hotel);
}
