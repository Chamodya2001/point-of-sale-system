package com.pos.kuppiya.point_of_sale1.util.mappers;

import com.pos.kuppiya.point_of_sale1.dto.request.ItemSaveDto;
import com.pos.kuppiya.point_of_sale1.dto.response.ItemDto;
import com.pos.kuppiya.point_of_sale1.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
     List<ItemDto> entityLidtToDtoList(List<Item> allItem) ;


    Item RequestDtoToEntity(ItemSaveDto itemSaveDto) ;

    List<ItemDto> pageToList(Page<Item> page);
}
