package com.dncomponents.northwind;

import com.dncomponents.northwind.dto.SupplierDTO;
import com.dncomponents.northwind.model.Supplier;
import com.dncomponents.northwind.repo.SupplierRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.dncomponents.northwind.dto.Api.SUPPLIERS;
import static com.dncomponents.northwind.dto.Api.SUPPLIER_ID;

@RestController
@RequestMapping(SUPPLIERS)
public class SuppliersController {

    @Autowired
    private SupplierRepo supplierRepo;

    public SuppliersController() {
    }

    @GetMapping
    public List<SupplierDTO> getSuppliers() {
        return new ModelMapper().map(supplierRepo.findAll(),
                new TypeToken<List<SupplierDTO>>() {
                }.getType());
    }

    //create or update
    @PutMapping
    public ResponseEntity<SupplierDTO> updateSupplier(@RequestBody SupplierDTO supplierDTO) {
        Supplier supplier;
        if (supplierDTO.getSupplier_id() == null)
            supplier = new Supplier();
        else
            supplier = supplierRepo.findById(supplierDTO.getSupplier_id()).get();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(supplierDTO, supplier);
        supplier = supplierRepo.save(supplier);
        modelMapper.map(supplier, supplierDTO);
        return new ResponseEntity<>(supplierDTO, HttpStatus.OK);
    }

    @DeleteMapping(SUPPLIER_ID)
    public ResponseEntity deleteSupplier(@PathVariable("supplierId") Integer supplierId) {
        final Optional<Supplier> byId = supplierRepo.findById(supplierId);
        if (byId.isPresent()) {
            supplierRepo.delete(byId.get());
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
