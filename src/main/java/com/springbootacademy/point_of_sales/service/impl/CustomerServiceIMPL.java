package com.springbootacademy.point_of_sales.service.impl;

import com.springbootacademy.point_of_sales.dto.CustomerDto;
import com.springbootacademy.point_of_sales.dto.request.CustomerUpdateDto;
import com.springbootacademy.point_of_sales.entity.Customer;
import com.springbootacademy.point_of_sales.exception.NotFoundException;
import com.springbootacademy.point_of_sales.repo.CustomerRepo;
import com.springbootacademy.point_of_sales.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer(
                customerDto.getCustomerId(),
                customerDto.getCustomerName(),
                customerDto.getCustomerAddress(),
                customerDto.getCustomerSalary(),
                customerDto.getContactNumber(),
                customerDto.getNic(),
                customerDto.isActive()
        );
        customerRepo.save(customer);
        return customerDto.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDto customerUpdateDto) {
        if (customerRepo.existsById(customerUpdateDto.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDto.getCustomerId());

            customer.setCustomerName(customerUpdateDto.getCustomerName());
            customer.setCustomerAddress(customerUpdateDto.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDto.getCustomerSalary());

            customerRepo.save(customer);

            return customerUpdateDto.getCustomerName() + "Updated Successfully";

        }else {
            throw new RuntimeException("No data found for that id");
        }
    }

    @Override
    public CustomerDto getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDto customerDto = new CustomerDto(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDto;
        }else {
            throw new RuntimeException("No customer");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
        if (getAllCustomers.size()>0){
            List<CustomerDto> customerDtoList = new ArrayList<>();
            for (Customer customer : getAllCustomers){
                CustomerDto customerDto = new CustomerDto(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getCustomerSalary(),
                        customer.getContactNumber(),
                        customer.getNic(),
                        customer.isActive()
                );
                customerDtoList.add(customerDto);
            }
            return customerDtoList;
        }else {
            throw new NotFoundException("No Customer Found");
        }

    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return customerId + " deleted successfully";
        }else {
            throw new RuntimeException("No customer for that id");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomersByActiveState(boolean activeState) {
        List<Customer> getAllCustomers = customerRepo.findAllByActiveEquals(activeState);
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for (Customer customer : getAllCustomers){
            CustomerDto customerDto = new CustomerDto(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDtoList.add(customerDto);
        }

        return customerDtoList;
    }
}
