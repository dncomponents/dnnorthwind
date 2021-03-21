package com.dncomponents.northwind.repo;

import com.dncomponents.northwind.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier, Integer> {
}
