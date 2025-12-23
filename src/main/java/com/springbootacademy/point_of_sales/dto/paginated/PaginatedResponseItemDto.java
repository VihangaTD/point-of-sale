package com.springbootacademy.point_of_sales.dto.paginated;

import com.springbootacademy.point_of_sales.dto.response.ItemGetResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDto {
    List<ItemGetResponseDto> list;
    private long dataCount;
}
