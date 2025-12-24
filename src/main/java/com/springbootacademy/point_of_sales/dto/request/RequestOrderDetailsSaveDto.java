package com.springbootacademy.point_of_sales.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailsSaveDto {
    private String itemName;
    private double qty;
    private double amount;
    private int item;
}
