package lk.ijse.gdse.MainTravelService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TravelServiceDTO {
    private long packageID;
    @JsonProperty("Category")
    private String category;
    @JsonProperty("StartDate")
    private Date startDate;
    @JsonProperty("EndDate")
    private Date endDate;
    @JsonProperty("TravelArea")
    private String travelArea;
    @JsonProperty("NoOfAdults")
    private int noOfAdults;
    @JsonProperty("NoOfChildren")
    private int noOfChildren;
    @JsonProperty("TotalHeadcount")
    private int totalHeadcount;
    @JsonProperty("WithPets")
    private boolean withPets;
    @JsonProperty("NeedGuide")
    private boolean needGuide;
    @JsonProperty("HotelFee")
    private double hotelFee;
    @JsonProperty("VehicleFee")
    private double vehicleFee;
    @JsonProperty("ServiceCharge")
    private double serviceCharge;
    @JsonProperty("UserId")
    private String userId;
    @JsonProperty("TotalAmount")
    private double totalAmount;
}
