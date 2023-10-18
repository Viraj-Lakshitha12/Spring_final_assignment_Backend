package lk.ijse.gdse.UserService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private long userId;
    private String user_nic;
    private byte[] frontSideImage;
    private byte[] backSideImage;
    private String gender;
    private String user_email;
    private String contact;
    private int user_age;
    private String user_address;
    private String user_remarks;
}
