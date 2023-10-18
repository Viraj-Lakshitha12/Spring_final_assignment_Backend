package lk.ijse.gdse.MainTravelService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Travel_Service") // Specify the new table name here
public class TravelService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long packageID;
    private String category;
    private Date startDate;
    private Date endDate;
    private String travelArea;
    private int noOfAdults;
    private int noOfChildren;
    private int totalHeadcount;
    private boolean withPets;
    private boolean needGuide;
    private double hotelFee;
    private double vehicleFee;
    private double serviceCharge;
    private String userId;
    private double totalAmount;
}
