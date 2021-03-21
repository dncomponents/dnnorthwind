package com.dncomponents.northwind.dto;

public interface Api {

    String ROOT_URL = "http://localhost:8080";
    String CUSTOMERS = "/api/customers";
    String EMPLOYEES = "/api/employees";
    String PRODUCTS = "/api/products";
    String ORDERS = "/api/orders";
    String ORDER_DETAILS = "/api/order_details";
    String SUPPLIERS = "/api/suppliers";
    String SUPPLIER_ID = "/{supplierId}";
    String ORDER_ID = "/{orderId}";
    String PRODUCT_ID = "/{productId}";
    String EMPLOYEE_ID = "/{employeeId}";
    String CUSTOMER_ID = "/{customerId}";

    static String r(String str) {
        return ROOT_URL + str;
    }
}
