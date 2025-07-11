package com.pos.kuppiya.point_of_sale1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemSaveDto {


    private String itemName;

    private String measuringUnitType;

    private double balanceQuantity;

    private double suplierPrice;

    private double selingPrice;

}
