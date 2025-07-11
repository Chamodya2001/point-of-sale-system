package com.pos.kuppiya.point_of_sale1.repo;

import com.pos.kuppiya.point_of_sale1.dto.response.CustomerDTO;
import com.pos.kuppiya.point_of_sale1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
@Transactional

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer getReferenceById(int id);

    List<Customer> findAllByCustomerNameEquals(String name);//equal=is=none  //findallby=readallby

    List<Customer> findAllByActiveStateEquals(boolean b);

    List<Customer> findAllByActiveState(boolean b);


    @Modifying
    @Query(value = "update customer set customer_name=?1,nic=?2 where customer_id=?3",nativeQuery = true)
    void updateCustomerByQuery(String customerName, String nic, int id);

    CustomerDTO findAllByNicEquals(String nic);


    List<Customer> findAllByIdEquals(int id);

    @Modifying
    @Query(value = "update customer set customer_name=?1,customer_salary=?2,nic=?3 where customer_id=?4",nativeQuery = true)
    void updateNameSalaryNic(String customerName, double customerSalary, String nic, int id);

    @Query(value = "select active_state=0 from customer where customer_id=?1",nativeQuery = true )
    boolean findActiveStateTrue(int id);

    Optional<Customer> findByNicEquals(String nic);
}
