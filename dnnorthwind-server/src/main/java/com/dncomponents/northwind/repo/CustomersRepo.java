package com.dncomponents.northwind.repo;

import com.dncomponents.northwind.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepo extends JpaRepository<Customer, Integer> {
}
