package com.dncomponents.northwind.repo;

import com.dncomponents.northwind.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepo extends JpaRepository<Employee, Integer> {
}
