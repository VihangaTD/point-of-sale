package com.springbootacademy.point_of_sales.repo;

import com.springbootacademy.point_of_sales.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails,Integer> {
}
