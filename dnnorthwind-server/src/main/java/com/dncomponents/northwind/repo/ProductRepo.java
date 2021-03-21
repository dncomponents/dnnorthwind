package com.dncomponents.northwind.repo;

import com.dncomponents.northwind.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
