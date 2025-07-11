package com.pos.kuppiya.point_of_sale1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponceOrderDetailsDto {
    //customer
    private String customerName;
    private String customerAddress;
    private String contactNumber;

    //order
    private Date date;
    private Double total;
}
