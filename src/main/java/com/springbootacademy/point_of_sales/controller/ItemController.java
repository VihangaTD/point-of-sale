package com.springbootacademy.point_of_sales.controller;

import com.springbootacademy.point_of_sales.dto.request.ItemSaveRequestDto;
import com.springbootacademy.point_of_sales.dto.request.ItemUpdateDto;
import com.springbootacademy.point_of_sales.dto.response.ItemGetResponseDto;
import com.springbootacademy.point_of_sales.service.ItemService;
import com.springbootacademy.point_of_sales.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDto itemSaveRequestDto){
        String message = itemService.saveCustomer(itemSaveRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            params = "name"
    )
    public List<ItemGetResponseDto> getItemByNameAndStatus(@RequestParam(value = "name")String itemName){
        List<ItemGetResponseDto> itemDtos = itemService.getItemByNameAndStatus(itemName);
        return itemDtos;
    }

    @GetMapping(
            path = "/mapstruct",
            params = "name"
    )
    public List<ItemGetResponseDto> getItemByNameAndStatusByMapStruct(@RequestParam(value = "name")String itemName){
        List<ItemGetResponseDto> itemDtos = itemService.getItemByNameAndStatusByMapStruct(itemName);
        return itemDtos;
    }

    @PutMapping
    public String updateItem(@RequestBody ItemUpdateDto itemUpdateDto){
        String message = itemService.updateItem(itemUpdateDto);
        return message;
    }
}
