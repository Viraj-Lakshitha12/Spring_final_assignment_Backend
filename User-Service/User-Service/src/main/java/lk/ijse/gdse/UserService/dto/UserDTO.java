package lk.ijse.gdse.UserService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private long user_id;

    @NotBlank(message = "User NIC is required")
    private String user_nic;

    @NotNull(message = "Front side image is required")
    private byte[] frontSideImage;

    @NotNull(message = "Back side image is required")
    private byte[] backSideImage;

    @NotBlank(message = "Gender is required")
    private String gender;

    @Email(message = "Invalid email format")
    private String user_email;

    @Size(min = 10, max = 15, message = "Contact number must be between 10 and 15 characters")
    private String contact;

    @NotNull(message = "User age is required")
    private int user_age;

    @NotBlank(message = "User address is required")
    private String user_address;

    @Size(max = 255, message = "Remarks should not exceed 255 characters")
    private String user_remarks;
}
