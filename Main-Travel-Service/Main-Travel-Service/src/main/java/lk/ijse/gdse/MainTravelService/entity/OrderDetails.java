package lk.ijse.gdse.MainTravelService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToOne(cascade = CascadeType.ALL)
    private Hotel hotel;

    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;

    @OneToOne(cascade = CascadeType.ALL)
    private Guide guide;

    private String orderDate;

    public OrderDetails(Hotel hotel, Vehicle vehicle, Guide guide) {
        this.hotel=hotel;
        this.vehicle=vehicle;
        this.guide=guide;
    }
}


