package lk.ijse.gdse.MainTravelService.api;


import lk.ijse.gdse.MainTravelService.entity.Guide;
import lk.ijse.gdse.MainTravelService.entity.Hotel;
import lk.ijse.gdse.MainTravelService.entity.OrderDetails;
import lk.ijse.gdse.MainTravelService.entity.Vehicle;
import lk.ijse.gdse.MainTravelService.service.GuideService;
import lk.ijse.gdse.MainTravelService.service.HotelService;
import lk.ijse.gdse.MainTravelService.service.OrderDetailsService;
import lk.ijse.gdse.MainTravelService.service.VehicleService;
import lk.ijse.gdse.MainTravelService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orderDetails")
@CrossOrigin
public class OrderDetailsController {
    private final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }


    @PostMapping("/saveData")
    public ResponseUtil saveData(@RequestBody OrderDetails orderDetails) {
        // Set the current date and time
        Date currentDate = new Date();
        orderDetails.setOrderDate(String.valueOf(currentDate));

        // Format the date portion as "yyyy-MM-dd" and set it to a String
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateOnly = dateFormat.format(currentDate);

        // Save the formatted date to the OrderDetails entity
        orderDetails.setOrderDate(dateOnly);

        // Save the entire order, which includes Hotel, Vehicle, and Guide
        OrderDetails savedOrder = orderDetailsService.saveOrderDetails(orderDetails);
        return new ResponseUtil(200, "Data saved successfully", savedOrder);
    }

    @GetMapping("/getAllData")
    public void getAllData(){
        List<OrderDetails> allOrderDetails = orderDetailsService.getAllOrderDetails();
        System.out.println(allOrderDetails.get(0));
    }
}
