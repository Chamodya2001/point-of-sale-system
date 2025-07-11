package com.pos.kuppiya.point_of_sale1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerUpdateNameSalaryNic {
    private String customerName;

    private double customerSalary;

    private String nic;


}
