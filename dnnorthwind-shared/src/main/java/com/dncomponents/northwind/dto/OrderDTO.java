package com.dncomponents.northwind.dto;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.dncomponents.northwind.dto.EncDecUtil.*;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class OrderDTO {

    Double order_id;
    CustomerDTO customer;
    EmployeeDTO employee;
    Double order_date;
    Double required_date;
    Double shipped_date;
    Double ship_via;
    Double freight;
    String ship_name;
    String ship_address;
    String ship_city;
    String ship_region;
    String ship_postal_code;
    String ship_country;

    OrderDetailDTO[] orderDetails;

    public final @JsOverlay
    List<OrderDetailDTO> getOrderDetails() {
        return Arrays.asList(orderDetails);
    }

    public final @JsOverlay
    void setOrderDetails(List<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails.toArray(new OrderDetailDTO[0]);
    }

    public final @JsOverlay
    Integer getOrder_id() {
        return getInt(order_id);
    }

    public final @JsOverlay
    void setOrder_id(Integer order_id) {
        this.order_id = setInt(order_id);
    }

    public final @JsOverlay
    CustomerDTO getCustomer() {
        return customer;
    }

    public final @JsOverlay
    void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public final @JsOverlay
    EmployeeDTO getEmployee() {
        return employee;
    }

    public final @JsOverlay
    void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public final @JsOverlay
    Date getOrder_date() {
        return getDate(order_date);
    }

    public final @JsOverlay
    void setOrder_date(Date order_date) {
        this.order_date = setDate(order_date);
    }

    public final @JsOverlay
    Date getRequired_date() {
        return getDate(required_date);
    }

    public final @JsOverlay
    void setRequired_date(Date required_date) {
        this.required_date = setDate(required_date);
    }

    public final @JsOverlay
    Date getShipped_date() {
        return getDate(shipped_date);
    }

    public final @JsOverlay
    void setShipped_date(Date shipped_date) {
        this.shipped_date = setDate(shipped_date);
    }

    public final @JsOverlay
    Integer getShip_via() {
        return getInt(ship_via);
    }

    public final @JsOverlay
    void setShip_via(Integer ship_via) {
        this.ship_via = setInt(ship_via);
    }

    public final @JsOverlay
    Double getFreight() {
        return freight;
    }

    public final @JsOverlay
    void setFreight(Double freight) {
        this.freight = freight;
    }

    public final @JsOverlay
    String getShip_name() {
        return ship_name;
    }

    public final @JsOverlay
    void setShip_name(String ship_name) {
        this.ship_name = ship_name;
    }

    public final @JsOverlay
    String getShip_address() {
        return ship_address;
    }

    public final @JsOverlay
    void setShip_address(String ship_address) {
        this.ship_address = ship_address;
    }

    public final @JsOverlay
    String getShip_city() {
        return ship_city;
    }

    public final @JsOverlay
    void setShip_city(String ship_city) {
        this.ship_city = ship_city;
    }

    public final @JsOverlay
    String getShip_region() {
        return ship_region;
    }

    public final @JsOverlay
    void setShip_region(String ship_region) {
        this.ship_region = ship_region;
    }

    public final @JsOverlay
    String getShip_postal_code() {
        return ship_postal_code;
    }

    public final @JsOverlay
    void setShip_postal_code(String ship_postal_code) {
        this.ship_postal_code = ship_postal_code;
    }

    public final @JsOverlay
    String getShip_country() {
        return ship_country;
    }

    public final @JsOverlay
    void setShip_country(String ship_country) {
        this.ship_country = ship_country;
    }

    public final @JsOverlay
    OrderDTOWrapper wrap() {
        return new OrderDTOWrapper(this);
    }

}
