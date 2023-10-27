package lk.ijse.gdse.UserService.entity;

import jakarta.persistence.Column;
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
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String  userName;
    private String user_nic;

    @Column(length = 10485760) // Adjust the length according to your needs (e.g., 10MB)
    private byte[] frontSideImage;

    @Column(length = 10485760) // Adjust the length according to your needs (e.g., 10MB)
    private byte[] backSideImage;

    private String gender;
    private String user_email;
    private String contact;
    private int user_age;
    private String user_address;
    private String user_Password;
    private String user_remarks;
}
