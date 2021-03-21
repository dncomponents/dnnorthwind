package com.dncomponents.northwind;

import com.dncomponents.northwind.dto.ProductDTO;
import com.dncomponents.northwind.model.Product;
import com.dncomponents.northwind.repo.ProductRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.dncomponents.northwind.dto.Api.PRODUCTS;
import static com.dncomponents.northwind.dto.Api.PRODUCT_ID;

@RestController
@RequestMapping(PRODUCTS)
public class ProductsController {

    @Autowired
    private ProductRepo productRepo;

    public ProductsController() {
    }

    @GetMapping
    public List<ProductDTO> getProducts() {
        return new ModelMapper().map(productRepo.findAll(),
                new TypeToken<List<ProductDTO>>() {
                }.getType());
    }

    //create or update
    @PutMapping
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        Product product;
        if (productDTO.getProduct_id() == null)
            product = new Product();
        else
            product = productRepo.findById(productDTO.getProduct_id()).get();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(productDTO, product);
        product = productRepo.save(product);
        modelMapper.map(product, productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @DeleteMapping(PRODUCT_ID)
    public ResponseEntity deleteProduct(@PathVariable("productId") Integer productId) {
        final Optional<Product> byId = productRepo.findById(productId);
        if (byId.isPresent()) {
            productRepo.delete(byId.get());
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
