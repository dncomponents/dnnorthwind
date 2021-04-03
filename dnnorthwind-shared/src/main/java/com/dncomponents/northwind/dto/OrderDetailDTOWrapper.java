package com.dncomponents.northwind.dto;


public class OrderDetailDTOWrapper {

    private OrderDetailDTO orderDetailDTO;

    public OrderDetailDTOWrapper(OrderDetailDTO orderDetailDTO) {
        this.orderDetailDTO = orderDetailDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailDTOWrapper that = (OrderDetailDTOWrapper) o;

        return getOrder_id().equals(that.getOrder_id());
    }

    @Override
    public int hashCode() {
        return getOrder_id().hashCode();
    }

    public Integer getOrder_id() {
        return orderDetailDTO.getOrder_id();
    }

    public void setOrder_id(Integer order_id) {
        orderDetailDTO.setOrder_id(order_id);
    }

    public ProductDTO getProduct() {
        return orderDetailDTO.getProduct();
    }

    public void setProduct(ProductDTO product) {
        orderDetailDTO.setProduct(product);
    }

    public Double getUnit_price() {
        return orderDetailDTO.getUnit_price();
    }

    public void setUnit_price(Double unit_price) {
        orderDetailDTO.setUnit_price(unit_price);
    }

    public Integer getQuantity() {
        return orderDetailDTO.getQuantity();
    }

    public void setQuantity(Integer quantity) {
        orderDetailDTO.setQuantity(quantity);
    }

    public Double getDiscount() {
        return orderDetailDTO.getDiscount();
    }

    public void setDiscount(Double discount) {
        orderDetailDTO.setDiscount(discount);
    }

    public OrderDetailDTO unWrap() {
        return orderDetailDTO;
    }

    @Override
    public String toString() {
        return orderDetailDTO.getOrder_id() + "";
    }
}
