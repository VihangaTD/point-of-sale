package com.springbootacademy.point_of_sales.service;

import com.springbootacademy.point_of_sales.dto.paginated.PaginatedResponseOrderDetailsDto;
import com.springbootacademy.point_of_sales.dto.request.RequestOrderSaveDto;
import jakarta.validation.constraints.Max;

public interface OrderService {

    String addOrder(RequestOrderSaveDto requestOrderSaveDto);

    PaginatedResponseOrderDetailsDto getAllOrderDetails(boolean status, int page, @Max(50) int size);
}
