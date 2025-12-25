package com.springbootacademy.point_of_sales.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderDetailsDto {
    //customer
    private String customerName;
    private String customerAddress;
    private ArrayList<String> contactNumbers;

    //order
    private Date date;
    private Double total;
}
