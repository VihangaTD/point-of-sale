package com.springbootacademy.point_of_sales.service;

import com.springbootacademy.point_of_sales.dto.request.ItemSaveRequestDto;
import com.springbootacademy.point_of_sales.dto.request.ItemUpdateDto;
import com.springbootacademy.point_of_sales.dto.response.ItemGetResponseDto;

import java.util.List;

public interface ItemService {
    public String saveCustomer(ItemSaveRequestDto itemSaveRequestDto);

    List<ItemGetResponseDto> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDto> getItemByNameAndStatusByMapStruct(String itemName);

    String updateItem(ItemUpdateDto itemUpdateDto);
}
