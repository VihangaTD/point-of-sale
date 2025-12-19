package com.springbootacademy.point_of_sales.util.mappers;

import com.springbootacademy.point_of_sales.dto.response.ItemGetResponseDto;
import com.springbootacademy.point_of_sales.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDto> entityListToDtoList(List<Item> items);
}
