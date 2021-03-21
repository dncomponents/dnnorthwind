package com.dncomponents.northwind.repo;

import com.dncomponents.northwind.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Order, Integer> {
}
