package com.pos.kuppiya.point_of_sale1.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.pos.kuppiya.point_of_sale1.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item")
@TypeDefs({
       @TypeDef(name = "json",typeClass = JsonTypeId.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Item {
    @Id
    @Column(name = "item_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Enumerated
    @Column(name = "measuring_unit", length = 100, nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_quantity", length = 100, nullable = false)
    private double balanceQuantity;

    @Column(name = "suplier_price", length = 100, nullable = false)
    private double suplierPrice;

    @Column(name = "seling_price", length = 100, nullable = false)
    private double selingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy="items")
    private Set<OrderDetails> orderDetails;


}

