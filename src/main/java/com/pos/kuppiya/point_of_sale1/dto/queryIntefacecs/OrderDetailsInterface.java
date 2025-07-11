package com.pos.kuppiya.point_of_sale1.dto.queryIntefacecs;

import java.sql.Date;

public interface OrderDetailsInterface {
    String  getCustomerName();
    String getCustomerAddress();
    String getContactNumber();

    Date getDate();
    Double getTotal();
}
