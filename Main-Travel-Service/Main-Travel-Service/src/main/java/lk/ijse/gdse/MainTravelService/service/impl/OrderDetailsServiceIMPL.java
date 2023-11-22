package lk.ijse.gdse.MainTravelService.service.impl;

import lk.ijse.gdse.MainTravelService.entity.OrderDetails;
import lk.ijse.gdse.MainTravelService.repository.OrderDetailsRepository;
import lk.ijse.gdse.MainTravelService.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrderDetailsServiceIMPL implements OrderDetailsService {
    @Autowired
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsServiceIMPL(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public OrderDetails saveOrderDetails(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }
}
