package com.springbootacademy.point_of_sales.dto.queryInterfaces;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailInterface {
    String getCustomerName();
    String getCustomerAddress();
    ArrayList<String> getContactNumber();
    Date getDate();
    Double getTotal();
}
