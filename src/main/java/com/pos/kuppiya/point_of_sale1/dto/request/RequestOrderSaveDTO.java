package com.pos.kuppiya.point_of_sale1.dto.request;

import com.pos.kuppiya.point_of_sale1.entity.Customer;
import com.pos.kuppiya.point_of_sale1.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {

    private int customer_id;
    private Date date;
    private Double total;
    private boolean activeState;
    private Set<OrderDetails> orderDetails;

}
