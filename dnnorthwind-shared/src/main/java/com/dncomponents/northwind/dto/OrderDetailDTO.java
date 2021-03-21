package com.dncomponents.northwind.dto;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

import static com.dncomponents.northwind.dto.EncDecUtil.getInt;
import static com.dncomponents.northwind.dto.EncDecUtil.setInt;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class OrderDetailDTO {

    Double order_id;
    ProductDTO product;
    Double unit_price;
    Double quantity;
    Double discount;

    public final @JsOverlay
    Integer getOrder_id() {
        return getInt(order_id);
    }

    public final @JsOverlay
    void setOrder_id(Integer order_id) {
        this.order_id = setInt(order_id);
    }

    public final @JsOverlay
    ProductDTO getProduct() {
        return product;
    }

    public final @JsOverlay
    void setProduct(ProductDTO product) {
        this.product = product;
    }

    public final @JsOverlay
    Double getUnit_price() {
        return unit_price;
    }

    public final @JsOverlay
    void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public final @JsOverlay
    Integer getQuantity() {
        return getInt(quantity);
    }

    public final @JsOverlay
    void setQuantity(Integer quantity) {
        this.quantity = setInt(quantity);
    }

    public final @JsOverlay
    Double getDiscount() {
        return discount;
    }

    public final @JsOverlay
    void setDiscount(Double discount) {
        this.discount = discount;
    }

    public final @JsOverlay
    OrderDetailDTOWrapper wrap() {
        return new OrderDetailDTOWrapper(this);
    }

}
