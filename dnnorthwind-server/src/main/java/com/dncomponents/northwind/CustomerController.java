package com.dncomponents.northwind;

import com.dncomponents.northwind.dto.Api;
import com.dncomponents.northwind.dto.CustomerDTO;
import com.dncomponents.northwind.model.Customer;
import com.dncomponents.northwind.repo.CustomersRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.dncomponents.northwind.dto.Api.CUSTOMER_ID;

@RestController
@RequestMapping(Api.CUSTOMERS)
public class CustomerController {

    @Autowired
    private CustomersRepo customerRepo;

    public CustomerController() {
    }

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return new ModelMapper().map(customerRepo.findAll(),
                new TypeToken<List<CustomerDTO>>() {
                }.getType());
    }

    //create or update
    @PutMapping
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer;
        if (customerDTO.getCustomer_id() == null)
            customer = new Customer();
        else
            customer = customerRepo.findById(customerDTO.getCustomer_id()).get();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(customerDTO, customer);
        customer = customerRepo.save(customer);
        modelMapper.map(customer, customerDTO);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @DeleteMapping(CUSTOMER_ID)
    public ResponseEntity deleteCustomer(@PathVariable("customerId") Integer customerId) {
        final Optional<Customer> byId = customerRepo.findById(customerId);
        if (byId.isPresent()) {
            customerRepo.delete(byId.get());
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
