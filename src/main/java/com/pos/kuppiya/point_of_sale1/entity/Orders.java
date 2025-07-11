package com.pos.kuppiya.point_of_sale1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @Column(name = "order_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;



    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer1;

    @Column(name = "order_date",columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total")
    private Double total;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;


    @OneToMany(mappedBy="orders")
    private Set<OrderDetails> orderDetails;


    public Orders(Customer customer1, Date date, Double total) {
        this.customer1 = customer1;
        this.date = date;
        this.total = total;
    }

}
