/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.dncomponents.northwind;

import com.dncomponents.northwind.dto.EmployeeDTO;
import com.dncomponents.northwind.model.Employee;
import com.dncomponents.northwind.repo.EmployeesRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.dncomponents.northwind.dto.Api.EMPLOYEES;
import static com.dncomponents.northwind.dto.Api.EMPLOYEE_ID;

@RestController
@RequestMapping(EMPLOYEES)
public class EmployeesController {

    @Autowired
    private EmployeesRepo employeeRepo;

    public EmployeesController() {
    }

    @GetMapping
    public List<EmployeeDTO> getEmployees() {
        return new ModelMapper().map(employeeRepo.findAll(),
                new TypeToken<List<EmployeeDTO>>() {
                }.getType());
    }

    //create or update
    @PutMapping
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee;
        if (employeeDTO.getEmployee_id() == null)
            employee = new Employee();
        else
            employee = employeeRepo.findById(employeeDTO.getEmployee_id()).get();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(employeeDTO, employee);
        employee = employeeRepo.save(employee);
        modelMapper.map(employee, employeeDTO);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @DeleteMapping(EMPLOYEE_ID)
    public ResponseEntity deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        final Optional<Employee> byId = employeeRepo.findById(employeeId);
        if (byId.isPresent()) {
            employeeRepo.delete(byId.get());
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
