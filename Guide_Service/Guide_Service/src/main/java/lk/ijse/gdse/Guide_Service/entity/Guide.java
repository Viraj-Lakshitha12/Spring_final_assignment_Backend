package lk.ijse.gdse.Guide_Service.entity;

import jakarta.persistence.*;
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
    @Column(length = 10485760)
    private byte[] guideImage;
    @Column(length = 10485760)
    private byte[] nicFrontImage;
    @Column(length = 10485760)
    private byte[] nicRearImage;
    @Column(length = 10485760)
    private byte[] guideIdFrontImage;
    @Column(length = 10485760)
    private byte[] guideIdRearImage;


}
