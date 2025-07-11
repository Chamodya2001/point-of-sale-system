package com.pos.kuppiya.point_of_sale1.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 import javax.persistence.*;
import java.util.Set;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

//@TypeDefs({
//        @TypeDef(name = "json",typeClass = JoinColumn.class)
//})



public class Customer {
    @Id
    @Column(name = "customer_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    private String customerAddress;
    private double customerSalary;

//    @Type(type = "json")
//    @Column(name = "contact_Number",columnDefinition = "json")
    private String contactNumber;

    @Column(name = "nic", length = 12, unique = true)
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy="customer1")
    private Set<Orders> orders;


    public Customer(String customerName, String customerAddress, double customerSalary, String contactNumber, String nic, boolean activeState) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.activeState = activeState;
    }


}

