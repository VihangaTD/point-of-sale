package com.springbootacademy.point_of_sales.dto.paginated;

import com.springbootacademy.point_of_sales.dto.response.ResponseOrderDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDetailsDto {
    private List<ResponseOrderDetailsDto> list;
    private long dataCount;
}
