package com.pos.kuppiya.point_of_sale1.controller;

import com.pos.kuppiya.point_of_sale1.dto.paginated.PaginatedItemDto;
import com.pos.kuppiya.point_of_sale1.dto.request.ItemSaveDto;
import com.pos.kuppiya.point_of_sale1.dto.response.ItemDto;
import com.pos.kuppiya.point_of_sale1.service.ItemService;
import com.pos.kuppiya.point_of_sale1.util.StandardResponce;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
@AllArgsConstructor
public class ItemController {
    @Autowired
    private ItemService itemService;


    @PostMapping(path = "/save-item")
    public ResponseEntity<StandardResponce> saveItem(@RequestBody ItemSaveDto itemSaveDto) {
        String id = itemService.addItem(itemSaveDto);
        return new ResponseEntity<StandardResponce>(
                new StandardResponce(201, id + "item successfuly saved", id),
                HttpStatus.CREATED

        );

    }

    @GetMapping(path = "/getAll-item")
    public ResponseEntity<StandardResponce> getAllItem() {
        List<ItemDto> allItem = itemService.getAllItem();
        return new ResponseEntity<StandardResponce>(
                new StandardResponce(200, "isuccessfuly ", allItem),
                HttpStatus.CREATED

        );


    }

    @GetMapping(path = "/getAll-item-by-state",
            params = "state"

    )
    public ResponseEntity<StandardResponce> getAllItemByState(@RequestParam(value = "state") String state) {
        if (state.equalsIgnoreCase("active") | state.equalsIgnoreCase("inactive")) {//equalsIgnore=uper,lovar case kess wenna na samana weddi

//            boolean states=false;
//            if(state.equalsIgnoreCase("active")){
//                states=true;
//            }

            boolean states = state.equalsIgnoreCase("active") ? true : false; // ?=nam,:=ehema nathn
            List<ItemDto> allItem = itemService.getAllItemByStateType(states);

            return new ResponseEntity<StandardResponce>(
                    new StandardResponce(200, "isuccessfuly ", allItem),
                    HttpStatus.OK

            );

        } else {
            List<ItemDto> allItem = itemService.getAllItem();
            return new ResponseEntity<StandardResponce>(
                    new StandardResponce(200, "isuccessfuly ", allItem),
                    HttpStatus.OK

            );

        }
    }
    @GetMapping(path = "/count-all-item")
    public ResponseEntity<StandardResponce> getAllItemCount(){

        int  itemCount = itemService.getItemCount();

        return new ResponseEntity<StandardResponce>(
                new StandardResponce(200, "isuccessfuly ", itemCount),
                HttpStatus.OK

        );


    }
    @GetMapping(path = "/get-all-item-paginated",
     params = {"page","size"}
    )
    public ResponseEntity<StandardResponce> getAllItemPaginated(
            @RequestParam(value = "page")  int page,
            @RequestParam(value = "size") @Max(50) int size)  {

        PaginatedItemDto paginatedItemDto=itemService.getAllItemPaginated(page,size);
        return new ResponseEntity<StandardResponce>(
                new StandardResponce(200, "isuccessfuly ", paginatedItemDto),
                HttpStatus.OK

        );

    }

    @GetMapping(path = "/get-all-active-item-paginated",
            params = {"page","size","activeStates"}
    )
    public ResponseEntity<StandardResponce> getAllActiveItemPaginated(
            @RequestParam(value = "page")  int page,
            @RequestParam(value = "size") @Max(50) int size,
            @RequestParam(value = "activeStates")  boolean activeStates
            )  {

        PaginatedItemDto paginatedItemDto=itemService.getAllActiveItemPaginated(page,size,activeStates);
        return new ResponseEntity<StandardResponce>(
                new StandardResponce(200, "isuccessfuly ", paginatedItemDto),
                HttpStatus.OK

        );

    }

}