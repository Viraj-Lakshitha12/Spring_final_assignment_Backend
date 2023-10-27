package lk.ijse.gdse.UserService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserDTO {
    private String fullName;
    private String username;
    private String email;
    private String contact;
    private String password;
    private String gender;
}
