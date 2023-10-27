package lk.ijse.travel.hotelservice.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Sudeera Madushan
 * @Date : 10/13/2023
 * @Project : Next Travel Pvt. Ltd
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    private String id,name,category,location,email,mapLocation,contactNoOne, contactNoTwo;
    private boolean petIsAllowed;
    private BigDecimal hotelFee;
    private boolean cancellationCriteriaIsFree;
    private BigDecimal cancellationFee;
    private String packageCategoryId;
    private List<HotelImageDTO> hotelImages = new ArrayList<>();
    private List<HotelOptionDTO> optionList;
}
