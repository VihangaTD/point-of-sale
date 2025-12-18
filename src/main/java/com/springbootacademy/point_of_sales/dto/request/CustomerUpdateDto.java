package com.springbootacademy.point_of_sales.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerUpdateDto {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
}
