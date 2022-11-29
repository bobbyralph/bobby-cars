package com.bobby;

import com.bobby.entities.OOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OOrder,Integer> {
    Page<OOrder> findAllBy(Pageable pageable);



}
