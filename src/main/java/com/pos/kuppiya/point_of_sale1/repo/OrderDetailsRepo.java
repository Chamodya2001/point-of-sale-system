package com.pos.kuppiya.point_of_sale1.repo;

import com.pos.kuppiya.point_of_sale1.entity.OrderDetails;
import com.pos.kuppiya.point_of_sale1.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails,Integer> {
}
