package lk.ijse.gdse.Hotel_Service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
