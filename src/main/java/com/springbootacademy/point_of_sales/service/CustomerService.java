package com.springbootacademy.point_of_sales.service;

import com.springbootacademy.point_of_sales.dto.CustomerDto;
import com.springbootacademy.point_of_sales.dto.request.CustomerUpdateDto;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDto customerDto);

    public String updateCustomer(CustomerUpdateDto customerUpdateDto);

    public CustomerDto getCustomerById(int customerId);

    public List<CustomerDto> getAllCustomers();

    public String deleteCustomer(int customerId);

    public List<CustomerDto> getAllCustomersByActiveState(boolean activeState);
}
