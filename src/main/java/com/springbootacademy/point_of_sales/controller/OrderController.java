package com.springbootacademy.point_of_sales.controller;

import com.springbootacademy.point_of_sales.dto.paginated.PaginatedResponseOrderDetailsDto;
import com.springbootacademy.point_of_sales.dto.request.ItemSaveRequestDto;
import com.springbootacademy.point_of_sales.dto.request.RequestOrderSaveDto;
import com.springbootacademy.point_of_sales.service.OrderService;
import com.springbootacademy.point_of_sales.util.StandardResponse;
import jakarta.validation.constraints.Max;
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

    @GetMapping(
            params = {"stateType","page","size"},
            path = "/get-order-details"
    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam(value = "stateType")String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size")@Max(50)int size
    ){
        PaginatedResponseOrderDetailsDto paginatedResponseOrderDetailsDto = null;

        if (stateType.equalsIgnoreCase("active")| stateType.equalsIgnoreCase("inactive")){
            boolean status = stateType.equalsIgnoreCase("active") ? true:false;
            paginatedResponseOrderDetailsDto = orderService.getAllOrderDetails(status,page,size);
        }

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",paginatedResponseOrderDetailsDto),
                HttpStatus.OK
        );
    }
}
