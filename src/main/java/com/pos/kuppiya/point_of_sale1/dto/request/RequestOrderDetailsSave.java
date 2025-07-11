package com.pos.kuppiya.point_of_sale1.dto.request;

import com.pos.kuppiya.point_of_sale1.entity.Item;
import com.pos.kuppiya.point_of_sale1.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailsSave {
    private String itemName;
    private double   Quantity;
    private Double amount;
    private Orders orders;
    private Item items;
}
