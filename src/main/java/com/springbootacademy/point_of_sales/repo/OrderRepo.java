package com.springbootacademy.point_of_sales.repo;

import com.springbootacademy.point_of_sales.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
}
