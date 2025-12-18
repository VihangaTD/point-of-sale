package com.springbootacademy.point_of_sales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private List<Integer> contactNumber;
    private String nic;
    private boolean active;
}
