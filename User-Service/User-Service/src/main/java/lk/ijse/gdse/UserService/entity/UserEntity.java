package lk.ijse.gdse.UserService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @NotBlank(message = "Username is required")
    @Size(max = 255, message = "Username cannot exceed 255 characters")
    private String userName;

    @NotBlank(message = "NIC is required")
    @Size(min = 10, max = 12, message = "NIC must be between 10 and 12 characters")
    private String user_nic;

    @Column(length = 10485760)
    private byte[] frontSideImage;

    @Column(length = 10485760)
    private byte[] backSideImage;

    @NotBlank(message = "Gender is required")
    @Size(max = 10, message = "Gender cannot exceed 10 characters")
    private String gender;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String user_email;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "\\d{10}", message = "Invalid contact number format. Must be 10 digits.")
    private String contact;

    @Min(value = 18, message = "User must be at least 18 years old")
    @Max(value = 150, message = "User age cannot exceed 150 years")
    private int user_age;

    @NotBlank(message = "User address is required")
    @Size(max = 255, message = "User address cannot exceed 255 characters")
    private String user_address;

    @NotBlank(message = "Password is required")
    @Size(min = 4, message = "Password must be at least 4 characters")
    private String user_Password;

    @Size(max = 255, message = "Remarks cannot exceed 255 characters")
    private String user_remarks;
}
