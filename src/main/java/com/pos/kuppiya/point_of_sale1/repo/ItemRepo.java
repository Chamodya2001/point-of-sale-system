package com.pos.kuppiya.point_of_sale1.repo;



import com.pos.kuppiya.point_of_sale1.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends JpaRepository<Item,Integer>{
    List<Item> findAllByActiveStateEquals(boolean states);

    int countAllByActiveStateEquals(boolean b);

    Page<Item> findAllByActiveStateEquals(boolean activeStates, Pageable of);
}
