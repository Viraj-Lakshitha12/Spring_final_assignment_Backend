package lk.ijse.gdse.MainTravelService.service;

import lk.ijse.gdse.MainTravelService.entity.OrderDetails;

import java.util.List;

public interface OrderDetailsService {
    OrderDetails saveOrderDetails(OrderDetails orderDetails);

    List<OrderDetails> getAllOrderDetails();
}
