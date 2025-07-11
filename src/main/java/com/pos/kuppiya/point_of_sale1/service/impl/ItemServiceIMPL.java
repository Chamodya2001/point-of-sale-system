package com.pos.kuppiya.point_of_sale1.service.impl;

import com.pos.kuppiya.point_of_sale1.dto.paginated.PaginatedItemDto;
import com.pos.kuppiya.point_of_sale1.dto.request.ItemSaveDto;
import com.pos.kuppiya.point_of_sale1.dto.response.ItemDto;
import com.pos.kuppiya.point_of_sale1.entity.Item;
import com.pos.kuppiya.point_of_sale1.excepton.EntryDuplicateException;
import com.pos.kuppiya.point_of_sale1.repo.ItemRepo;
import com.pos.kuppiya.point_of_sale1.service.ItemService;
import com.pos.kuppiya.point_of_sale1.util.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
   private ItemMapper itemMapper;


    @Override
    public String addItem(ItemSaveDto itemSaveDto) {
        Item item=itemMapper.RequestDtoToEntity(itemSaveDto);
        item.setActiveState(true);
        if(!itemRepo.existsById(item.getItemId())){
           return itemRepo.save(item).getItemName();

        }else{
            throw new EntryDuplicateException("all ready in database");
        }

    }

    @Override
    public List<ItemDto> getAllItem() {
        List<Item> allitem =itemRepo.findAll();
        List<ItemDto> cu=itemMapper.entityLidtToDtoList(allitem);
        return cu;

    }

    @Override
    public List<ItemDto> getAllItemByStateType(boolean states) {
        List<Item> allitem =itemRepo.findAllByActiveStateEquals(states);
        List<ItemDto> cu=itemMapper.entityLidtToDtoList(allitem);
        return cu;
    }

    @Override
    public int getItemCount() {
        int count=itemRepo.countAllByActiveStateEquals(true);
        return count;
    }

    @Override
    public PaginatedItemDto getAllItemPaginated(int page, int size) {
        Page<Item> getAllItemsByPaginated=itemRepo.findAll(PageRequest.of(page,size));
         return new PaginatedItemDto(
                 itemMapper.pageToList(getAllItemsByPaginated),
                 itemRepo.count()
         );
    }

    @Override
    public PaginatedItemDto getAllActiveItemPaginated(int page, int size, boolean activeStates) {
        Page<Item> getAllActiveItemsByPaginated=itemRepo.findAllByActiveStateEquals(activeStates,PageRequest.of(page,size));
        return new PaginatedItemDto(
                itemMapper.pageToList(getAllActiveItemsByPaginated),
                (long) itemRepo.countAllByActiveStateEquals(activeStates)
        );
    }
}
