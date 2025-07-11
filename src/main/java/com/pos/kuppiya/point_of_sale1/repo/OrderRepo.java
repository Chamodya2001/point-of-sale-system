package com.pos.kuppiya.point_of_sale1.repo;



import com.pos.kuppiya.point_of_sale1.dto.queryIntefacecs.OrderDetailsInterface;
import com.pos.kuppiya.point_of_sale1.entity.Orders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@EnableJpaRepositories
@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer> {
    @Query(value="select c.customer_name as customerName,c.customer_address as customerAddress,c.contact_number as contactNumber," +
            "o.order_date as Dates,o.total as total" +
            "from customer c,orders o" +
            " where  c.active_state=?1 and c.customer_id=o.customer_id",nativeQuery = true)
    List<OrderDetailsInterface> getAllOrderDetails(boolean states, Pageable of);


    @Query(value="select count(*) "+
            "from customer c,orders o" +
            " where  o.active_state=?1 and c.customer_id=o.customer_id",nativeQuery = true)
    long countAllOrderDetails(boolean states);
}
