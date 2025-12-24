package com.springbootacademy.point_of_sales.service;

import com.springbootacademy.point_of_sales.dto.request.RequestOrderSaveDto;

public interface OrderService {

    String addOrder(RequestOrderSaveDto requestOrderSaveDto);
}
