package lk.ijse.gdse.Hotel_Service.api;


import lk.ijse.gdse.Hotel_Service.dto.HotelDTO;
import lk.ijse.gdse.Hotel_Service.entity.Hotel;
import lk.ijse.gdse.Hotel_Service.repository.HotelRepo;
import lk.ijse.gdse.Hotel_Service.service.HotelService;
import lk.ijse.gdse.Hotel_Service.util.DataTypeConversion;
import lk.ijse.gdse.Hotel_Service.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/hotel")
public class HotelServiceController {

    @Autowired
    private final HotelService hotelService;
    @Autowired
    private final DataTypeConversion dataTypeConversion;

    public HotelServiceController(HotelService hotelservice, DataTypeConversion dataTypeConversion) {
        this.hotelService = hotelservice;
        this.dataTypeConversion = dataTypeConversion;
    }

    @PostMapping(value = "/saveHotel",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveData(@RequestBody HotelDTO hotelDTO){
        Hotel hotel = hotelService.saveData(dataTypeConversion.getGuideEntity(hotelDTO));
        return new ResponseUtil(201, "saved", hotel);
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<List<Hotel>> getAllData(){
        List<Hotel> allHotelData = hotelService.getAllData();
        return !allHotelData.isEmpty() ? ResponseEntity.ok(allHotelData) : ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/updateHotel",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseUtil> updateGuideDetails( @RequestBody HotelDTO hotelDTO) {
        Hotel hotel = hotelService.updateHotel(dataTypeConversion.getGuideEntity(hotelDTO));

        if (hotel != null) {
            return ResponseEntity.ok(new ResponseUtil(201,"Guide details updated successfully", hotel));
        } else {
            // Handle the case where the update operation fails
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil(500,"Failed to update guide details", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/findHotelById/{hotelId}")
    public ResponseUtil findHotelById(@PathVariable Long hotelId){
        Optional<Hotel> hotel = hotelService.findHotelById(hotelId);
        if (hotel.isPresent()){
            return new ResponseUtil(200,"found",hotel);
        }
        return new ResponseUtil(500,"Internal Server Error","");
    }

    @DeleteMapping("/deleteHotel/{hotelId}")
    public ResponseUtil deleteHotel(@PathVariable Long hotelId){
        hotelService.deleteHotel(hotelId);
        return new ResponseUtil(200,"Delete Hotel Success",null);
    }

}
