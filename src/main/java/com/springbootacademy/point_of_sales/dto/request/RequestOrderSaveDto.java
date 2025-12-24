package com.springbootacademy.point_of_sales.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDto {
    private int customer;
    private Date date;
    private double total;
    private List<RequestOrderDetailsSaveDto> orderDetails;
}
