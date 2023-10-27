package lk.ijse.gdse.Hotel_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDTO {
    private Long hotelId;
    private String hotelName;
    private String hotelPlan;
    private String hotelCategory;
    private String hotelLocation;
    private String hotelEmail;
    private String contactNumber1;
    private String contactNumber2;
    private boolean petsAllowed;
    private String hotelFee;
    private String cancellationCriteria;
    private String userRemarks;
}
