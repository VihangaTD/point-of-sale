package com.springbootacademy.point_of_sales.util.mappers;

import com.springbootacademy.point_of_sales.dto.response.ItemGetResponseDto;
import com.springbootacademy.point_of_sales.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDto> entityListToDtoList(List<Item> items);

    //Page<Item> items ---------> List<ItemGetResponseDto> list
    List<ItemGetResponseDto> pageToListDto(Page<Item> items);
}
