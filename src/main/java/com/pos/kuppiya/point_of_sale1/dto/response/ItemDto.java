package com.pos.kuppiya.point_of_sale1.dto.response;

import com.pos.kuppiya.point_of_sale1.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemDto {
    private int itemId;


    private String itemName;

    private MeasuringUnitType measuringUnitType;

    private double balanceQuantity;

    private double suplierPrice;

    private double selingPrice;

    private boolean activeState;
}
