package com.pos.kuppiya.point_of_sale1.service;

import com.pos.kuppiya.point_of_sale1.dto.paginated.PaginatedItemDto;
import com.pos.kuppiya.point_of_sale1.dto.request.ItemSaveDto;
import com.pos.kuppiya.point_of_sale1.dto.response.ItemDto;
import com.pos.kuppiya.point_of_sale1.service.impl.ItemServiceIMPL;

import java.util.List;

public interface ItemService  {

    String addItem(ItemSaveDto itemSaveDto);

    List<ItemDto> getAllItem();

    List<ItemDto> getAllItemByStateType(boolean states);

    int getItemCount();

    PaginatedItemDto getAllItemPaginated(int page, int size);

    PaginatedItemDto getAllActiveItemPaginated(int page, int size, boolean activeStates);
}
