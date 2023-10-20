package lk.ijse.gdse.Guide_Service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated ID
    private String guideName;
    private String guideAddress;
    private String guideAge;
    private String gender;
    private String contactNumber;
    private int manDayValue;
    private String experience;
    private String userRemarks;
    private byte[] guideImage;
    private byte[] nicFrontImage;
    private byte[] nicRearImage;
    private byte[] guideIdFrontImage;
    private byte[] guideIdRearImage;


}
