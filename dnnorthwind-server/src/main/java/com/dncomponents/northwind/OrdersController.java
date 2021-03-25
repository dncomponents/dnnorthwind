package com.dncomponents.northwind;

import com.dncomponents.northwind.dto.OrderDTO;
import com.dncomponents.northwind.model.Order;
import com.dncomponents.northwind.repo.OrdersRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.dncomponents.northwind.dto.Api.ORDERS;
import static com.dncomponents.northwind.dto.Api.ORDER_ID;

@RestController
@RequestMapping(ORDERS)
public class OrdersController {

    @Autowired
    private OrdersRepo ordersRepo;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OrdersController() {
    }

    @GetMapping
    public List<OrderDTO> getOrders() {
        return new ModelMapper().map(ordersRepo.findAll(),
                new TypeToken<List<OrderDTO>>() {
                }.getType());
    }

    @GetMapping("/stat")
    public List<Map<String, Object>> getOrdersByCountries() {
        return jdbcTemplate.queryForList("select count(*) as value, " +
                "ship_country as name from orders group by ship_country");
    }

    //create or update
    @PutMapping
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDTO) {
        Order order;
        if (orderDTO.getOrder_id() == null)
            order = new Order();
        else
            order = ordersRepo.findById(orderDTO.getOrder_id()).get();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(orderDTO, order);
        order = ordersRepo.save(order);
        modelMapper.map(order, orderDTO);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @DeleteMapping(ORDER_ID)
    public ResponseEntity deleteOrder(@PathVariable("orderId") Integer orderId) {
        final Optional<Order> byId = ordersRepo.findById(orderId);
        if (byId.isPresent()) {
            ordersRepo.delete(byId.get());
            return new ResponseEntity(HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
