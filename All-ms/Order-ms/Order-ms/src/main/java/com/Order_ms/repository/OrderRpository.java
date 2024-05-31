package com.Order_ms.repository;

import com.Order_ms.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRpository extends JpaRepository<Order,Long> {
}
