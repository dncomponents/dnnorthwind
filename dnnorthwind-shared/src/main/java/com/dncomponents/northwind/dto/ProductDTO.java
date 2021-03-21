package com.dncomponents.northwind.dto;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

import static com.dncomponents.northwind.dto.EncDecUtil.getInt;
import static com.dncomponents.northwind.dto.EncDecUtil.setInt;


@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ProductDTO {

    Double product_id;
    String product_name;
    Double supplier_id;
    Double category_id;
    String quantity_per_unit;
    Double unit_price;
    Double units_in_stock;
    Double units_on_order;
    Double reorder_level;
    Boolean discontinued;

    public final @JsOverlay
    Integer getProduct_id() {
        return getInt(product_id);
    }

    public final @JsOverlay
    void setProduct_id(Integer product_id) {
        this.product_id = setInt(product_id);
    }

    public final @JsOverlay
    String getProduct_name() {
        return product_name;
    }

    public final @JsOverlay
    void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public final @JsOverlay
    Integer getSupplier_id() {
        return getInt(supplier_id);
    }

    public final @JsOverlay
    void setSupplier_id(Integer supplier_id) {
        this.supplier_id = setInt(supplier_id);
    }

    public final @JsOverlay
    Integer getCategory_id() {
        return getInt(category_id);
    }

    public final @JsOverlay
    void setCategory_id(Integer category_id) {
        this.category_id = setInt(category_id);
    }

    public final @JsOverlay
    String getQuantity_per_unit() {
        return quantity_per_unit;
    }

    public final @JsOverlay
    void setQuantity_per_unit(String quantity_per_unit) {
        this.quantity_per_unit = quantity_per_unit;
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
    Integer getUnits_in_stock() {
        return getInt(units_in_stock);
    }

    public final @JsOverlay
    void setUnits_in_stock(Integer units_in_stock) {
        this.units_in_stock = setInt(units_in_stock);
    }

    public final @JsOverlay
    Integer getUnits_on_order() {
        return getInt(units_on_order);
    }

    public final @JsOverlay
    void setUnits_on_order(Integer units_on_order) {
        this.units_on_order = setInt(units_on_order);
    }

    public final @JsOverlay
    Integer getReorder_level() {
        return getInt(reorder_level);
    }

    public final @JsOverlay
    void setReorder_level(Integer reorder_level) {
        this.reorder_level = setInt(reorder_level);
    }

    public final @JsOverlay
    Boolean getDiscontinued() {
        return this.discontinued;
    }

    public final @JsOverlay
    void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }

}
