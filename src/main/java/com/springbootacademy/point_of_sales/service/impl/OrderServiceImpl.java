package com.springbootacademy.point_of_sales.service.impl;

import com.springbootacademy.point_of_sales.dto.request.RequestOrderSaveDto;
import com.springbootacademy.point_of_sales.entity.Order;
import com.springbootacademy.point_of_sales.entity.OrderDetails;
import com.springbootacademy.point_of_sales.repo.CustomerRepo;
import com.springbootacademy.point_of_sales.repo.ItemRepo;
import com.springbootacademy.point_of_sales.repo.OrderDetailsRepo;
import com.springbootacademy.point_of_sales.repo.OrderRepo;
import com.springbootacademy.point_of_sales.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDto requestOrderSaveDto) {
        Order order = new Order(
                customerRepo.getReferenceById(requestOrderSaveDto.getCustomer()),
                requestOrderSaveDto.getDate(),
                requestOrderSaveDto.getTotal()
        );

        orderRepo.save(order);

        if (orderRepo.existsById(order.getOrderId())){
//            List<OrderDetails> orderDetails = new ArrayList<>();

            List<OrderDetails> orderDetails = modelMapper.
                    map(requestOrderSaveDto.getOrderDetails(),new TypeToken<List<OrderDetails>>(){
                    }.getType());

            for (int i=0;i<orderDetails.size();i++){
                orderDetails.get(i).setOrder(order);
                orderDetails.get(i).setItem(itemRepo.getReferenceById(requestOrderSaveDto.getOrderDetails().get(i).getItem()));
            }

            if (orderDetails.size()>0){
                orderDetailsRepo.saveAll(orderDetails);
            }
            return "saved";
        }
        return null;
    }
}
