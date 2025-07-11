package com.pos.kuppiya.point_of_sale1.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.criterion.Order;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonTypeId.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetails {

    @Id
    @Column(name = "item_details_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailsId;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Column(name = "quantity", length = 100, nullable = false)
    private double   Quantity;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item items;
}

