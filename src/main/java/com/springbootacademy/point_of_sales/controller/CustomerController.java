package com.springbootacademy.point_of_sales.controller;

import com.springbootacademy.point_of_sales.dto.CustomerDto;
import com.springbootacademy.point_of_sales.dto.request.CustomerUpdateDto;
import com.springbootacademy.point_of_sales.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String saveCustomer(@RequestBody CustomerDto customerDto){
        String message = customerService.saveCustomer(customerDto);
        return message;
    }

    @PutMapping
    public String updateCustomer(@RequestBody CustomerUpdateDto customerUpdateDto){
        String message = customerService.updateCustomer(customerUpdateDto);
        return message;
    }

    @GetMapping(
            path = "get-by-id",
            params = "id"
    )
    public CustomerDto getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return customerDto;
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers(){
        List<CustomerDto> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String message = customerService.deleteCustomer(customerId);
        return message;
    }

    @GetMapping("/{status}")
    public List<CustomerDto> getAllCustomersByActiveState(@PathVariable(value = "status") boolean activeState){
        List<CustomerDto> allCustomers = customerService.getAllCustomersByActiveState(activeState);
        return allCustomers;
    }

}
