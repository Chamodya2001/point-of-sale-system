package com.pos.kuppiya.point_of_sale1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerUpdateRequstDTO {
    private int id;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private String contactNumber;
    private String nic;


}
