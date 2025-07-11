package com.pos.kuppiya.point_of_sale1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponceSalaryAddIdDto {

    private int id;

    private String customerAddress;
    private double customerSalary;

}
