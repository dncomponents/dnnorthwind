package com.dncomponents.northwind.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "order_details")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId order_detail_id;
    private Integer quantity;
    private Double discount;
    private Double unit_price;

    public OrderDetail() {
    }

    public OrderDetailId getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(OrderDetailId id) {
        this.order_detail_id = id;
    }

    public Product getProduct() {
        return order_detail_id.getProduct();
    }

    public void setProduct(Product product) {
        this.order_detail_id.setProduct(product);
    }


    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
