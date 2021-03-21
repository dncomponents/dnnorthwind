package com.dncomponents.northwind.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class OrderDTOWrapper {

    private OrderDTO orderDTO;

    public OrderDTOWrapper(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public OrderDTOWrapper() {
        this.orderDTO = new OrderDTO();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTOWrapper that = (OrderDTOWrapper) o;
        return this.getOrder_id().equals(that.getOrder_id());
    }

    @Override
    public int hashCode() {
        return this.getOrder_id().hashCode();
    }

    public List<OrderDetailDTOWrapper> getOrderDetails() {
        return orderDTO.getOrderDetails().stream()
                .map(o -> o.wrap())
                .collect(Collectors.toList());
    }


    public void setOrderDetails(List<OrderDetailDTOWrapper> orderDetails) {
        orderDTO.setOrderDetails(orderDetails.stream()
                .map(o -> o.unWrap())
                .collect(Collectors.toList())
        );
    }

    public Integer getOrder_id() {
        return orderDTO.getOrder_id();
    }

    public void setOrder_id(Integer order_id) {
        orderDTO.setOrder_id(order_id);
    }

    public CustomerDTOWrapper getCustomer() {
        return orderDTO.getCustomer().wrap();
    }

    public void setCustomer(CustomerDTOWrapper customer) {
        orderDTO.setCustomer(customer.unWrap());
    }

    public EmployeeDTOWrapper getEmployee() {
        return orderDTO.getEmployee().wrap();
    }


    public void setEmployee(EmployeeDTOWrapper employee) {
        orderDTO.setEmployee(employee.unWrap());
    }

    public Date getOrder_date() {
        return orderDTO.getOrder_date();
    }

    public void setOrder_date(Date order_date) {
        orderDTO.setOrder_date(order_date);
    }

    public Date getRequired_date() {
        return orderDTO.getRequired_date();
    }

    public void setRequired_date(Date required_date) {
        orderDTO.setRequired_date(required_date);
    }

    public Date getShipped_date() {
        return orderDTO.getShipped_date();
    }

    public void setShipped_date(Date shipped_date) {
        orderDTO.setShipped_date(shipped_date);
    }

    public Integer getShip_via() {
        return orderDTO.getShip_via();
    }

    public void setShip_via(Integer ship_via) {
        orderDTO.setShip_via(ship_via);
    }

    public Double getFreight() {
        return orderDTO.getFreight();
    }

    public void setFreight(Double freight) {
        orderDTO.setFreight(freight);
    }

    public String getShip_name() {
        return orderDTO.getShip_name();
    }

    public void setShip_name(String ship_name) {
        orderDTO.setShip_name(ship_name);
    }

    public String getShip_address() {
        return orderDTO.getShip_address();
    }

    public void setShip_address(String ship_address) {
        orderDTO.setShip_address(ship_address);
    }

    public String getShip_city() {
        return orderDTO.getShip_city();
    }

    public void setShip_city(String ship_city) {
        orderDTO.setShip_city(ship_city);
    }

    public String getShip_region() {
        return orderDTO.getShip_region();
    }

    public void setShip_region(String ship_region) {
        orderDTO.setShip_region(ship_region);
    }

    public String getShip_postal_code() {
        return orderDTO.getShip_postal_code();
    }

    public void setShip_postal_code(String ship_postal_code) {
        orderDTO.setShip_postal_code(ship_postal_code);
    }

    public String getShip_country() {
        return orderDTO.getShip_country();
    }

    public void setShip_country(String ship_country) {
        orderDTO.setShip_country(ship_country);
    }

    public OrderDTO unWrap() {
        return orderDTO;
    }

}
