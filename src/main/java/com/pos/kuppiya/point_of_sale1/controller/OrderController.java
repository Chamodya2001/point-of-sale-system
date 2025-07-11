package com.pos.kuppiya.point_of_sale1.controller;


import com.pos.kuppiya.point_of_sale1.dto.paginated.PaginatedResponceOrderDetails;
import com.pos.kuppiya.point_of_sale1.dto.request.RequestOrderSaveDTO;
import com.pos.kuppiya.point_of_sale1.service.OrderService;
import com.pos.kuppiya.point_of_sale1.util.StandardResponce;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@CrossOrigin
@RequestMapping("api/v1/order")
@AllArgsConstructor
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save-order")
    public ResponseEntity<StandardResponce> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO) {
        String id = orderService.addOrder(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponce>(
                new StandardResponce(201, id + "item successfuly saved", id),
                HttpStatus.CREATED

        );
    }
    @GetMapping(path = "/get-order-details",
            params = {"stateType","page","size"}

    )
    public ResponseEntity<StandardResponce> getorderDetails
            (@RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
    ) {
        PaginatedResponceOrderDetails paginatedResponceOrderDetails = null;

        if (stateType.equalsIgnoreCase("active") | stateType.equalsIgnoreCase("inactive")) {

            boolean states = stateType.equalsIgnoreCase("active") ? true : false;
            paginatedResponceOrderDetails=orderService.getAllOrderDetails(states,page,size);
        }

            return new ResponseEntity<StandardResponce>(
                    new StandardResponce(200,"sucsess",paginatedResponceOrderDetails),
                    HttpStatus.OK
            );


        }
    }
