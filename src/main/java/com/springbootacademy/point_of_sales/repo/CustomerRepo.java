package com.springbootacademy.point_of_sales.repo;

import com.springbootacademy.point_of_sales.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    List<Customer> findAllByActiveEquals(boolean activeState);
}
