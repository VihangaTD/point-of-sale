package com.springbootacademy.point_of_sales.service.impl;

import com.springbootacademy.point_of_sales.dto.paginated.PaginatedResponseItemDto;
import com.springbootacademy.point_of_sales.dto.request.ItemSaveRequestDto;
import com.springbootacademy.point_of_sales.dto.request.ItemUpdateDto;
import com.springbootacademy.point_of_sales.dto.response.ItemGetResponseDto;
import com.springbootacademy.point_of_sales.entity.Item;
import com.springbootacademy.point_of_sales.exception.NotFoundException;
import com.springbootacademy.point_of_sales.repo.ItemRepo;
import com.springbootacademy.point_of_sales.service.ItemService;
import com.springbootacademy.point_of_sales.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveCustomer(ItemSaveRequestDto itemSaveRequestDto) {

//        Item item = new Item(
//                itemSaveRequestDto.getCustomerId(),
//                itemSaveRequestDto.getItemName(),
//                itemSaveRequestDto.getMeasuringUnitType(),
//                itemSaveRequestDto.getBalanceQty(),
//                itemSaveRequestDto.getSupplierPrice(),
//                itemSaveRequestDto.getSellingPrice()
//        );
//
//        itemRepo.save(item);
//        return item.getItemName();

//        manual mapping
//        Item item = new Item();
//        item.setItemName(dto.getItemName());
//        item.setMeasuringUnitType(dto.getMeasuringUnitType());
//        item.setBalanceQty(dto.getBalanceQty());
//        item.setSupplierPrice(dto.getSupplierPrice());
//        item.setSellingPrice(dto.getSellingPrice());
//        item.setActiveState(true); // default value
//        itemRepo.save(item);

        Item item = modelMapper.map(itemSaveRequestDto,Item.class);
        if (!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemName()+" saved item";
        }else {
            throw new DuplicateKeyException("Already Exist");
        }
    }

    @Override
    public List<ItemGetResponseDto> getItemByNameAndStatus(String itemName) {
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,b);

        if (items.size()>0){
            List<ItemGetResponseDto> itemGetResponseDtos = modelMapper
                    .map(items,new TypeToken<List<ItemGetResponseDto>>(){}.getType());

            return itemGetResponseDtos;
        }else {
            throw new RuntimeException("item is not active");
        }
    }

    @Override
    public List<ItemGetResponseDto> getItemByNameAndStatusByMapStruct(String itemName) {
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,b);

        if (items.size()>0){
            List<ItemGetResponseDto> itemGetResponseDtos = itemMapper.entityListToDtoList(items);
            return itemGetResponseDtos;
        }else {
            throw new RuntimeException("item is not active");
        }
    }

    @Override
    public String updateItem(ItemUpdateDto itemUpdateDto) {
        if (itemRepo.existsById(itemUpdateDto.getItemId())){
            Item item = itemRepo.getReferenceById(itemUpdateDto.getItemId());

            item.setItemName(itemUpdateDto.getItemName());
            item.setBalanceQty(item.getBalanceQty());
            item.setMeasuringUnitType(itemUpdateDto.getMeasuringUnitType());
            item.setSupplierPrice(itemUpdateDto.getSupplierPrice());
            item.setSellingPrice(itemUpdateDto.getSellingPrice());

            itemRepo.save(item);
            return item.getItemName()+" updated";
        }else {
            throw new RuntimeException("Item not exist");
        }
    }

    @Override
    public List<ItemGetResponseDto> getItemByActiveStatus(Boolean activeStatus) {

        List<Item> items = itemRepo.findAllByActiveStateEquals(activeStatus);

        if (items.size()>0){
            List<ItemGetResponseDto> itemGetResponseDtos = itemMapper.entityListToDtoList(items);
            return itemGetResponseDtos;
        }else {
            throw new NotFoundException("item is not found");
        }
    }

    @Override
    public PaginatedResponseItemDto getItemByActiveStatusWithPagination(Boolean activeStatus, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(activeStatus, PageRequest.of(page,size));
        int count = itemRepo.countAllByActiveStateEquals(activeStatus);

        if (items.getSize()<1){
            throw new NotFoundException("No Data");
        }
        PaginatedResponseItemDto paginatedResponseItemDto = new PaginatedResponseItemDto(
            itemMapper.pageToListDto(items),
                count
        );
        return paginatedResponseItemDto;
    }
}
