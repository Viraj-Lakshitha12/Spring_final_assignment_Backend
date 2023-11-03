package lk.ijse.gdse.MainTravelService.entity;

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
    private Long hotelId;
    private String hotelName;
    private String hotelLocation;
    private String hotelEmail;
    private String contactNumber1;
    private String hotelFee;
}
