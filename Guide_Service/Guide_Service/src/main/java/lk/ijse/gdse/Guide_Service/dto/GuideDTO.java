package lk.ijse.gdse.Guide_Service.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuideDTO {
    private Long guideId;
    private String guideName;
    private String guideAddress;
    private String guideAge;
    private String gender;
    private String contactNumber;
    private int manDayValue;
    private String experience;
    private String userRemarks;
    @Column(length = 10485760)
    private byte[] guideImage;  // Storing image as byte array
    private byte[] nicFrontImage;
    private byte[] nicRearImage;
    private byte[] guideIdFrontImage;
    private byte[] guideIdRearImage;


    public GuideDTO(String name, String address, String age, String gender, String contactNumber, int manDayValue, byte [] guideImage) {
        this.guideName=name;
        this.guideAddress=address;
        this.guideAge=age;
        this.gender=gender;
        this.contactNumber=contactNumber;
        this.manDayValue=manDayValue;
        this.guideImage=guideImage;
    }
}
