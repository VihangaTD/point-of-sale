package com.springbootacademy.point_of_sales.controller;

import com.springbootacademy.point_of_sales.dto.request.ItemSaveRequestDto;
import com.springbootacademy.point_of_sales.dto.request.RequestOrderSaveDto;
import com.springbootacademy.point_of_sales.service.OrderService;
import com.springbootacademy.point_of_sales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDto requestOrderSaveDto){
        String id = orderService.addOrder(requestOrderSaveDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",2),
                HttpStatus.CREATED
        );
    }
}
