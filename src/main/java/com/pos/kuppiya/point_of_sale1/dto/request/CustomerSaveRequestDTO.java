package com.pos.kuppiya.point_of_sale1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerSaveRequestDTO {


    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private String contactNumber;
    private String nic;



}
