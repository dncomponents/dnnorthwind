package com.dncomponents.northwind.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Embeddable
public class OrderDetailId implements Serializable {
    Integer order_id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderDetailId() {
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
