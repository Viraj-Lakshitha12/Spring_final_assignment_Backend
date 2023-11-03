package lk.ijse.gdse.MainTravelService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Guide {
    @Id
    private Long id;
    private String guideName;
    private String guideAddress;
    private String guideAge;
    private String contactNumber;
    private int manDayValue;
}
