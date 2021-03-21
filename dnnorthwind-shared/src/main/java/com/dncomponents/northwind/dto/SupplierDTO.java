package com.dncomponents.northwind.dto;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

import static com.dncomponents.northwind.dto.EncDecUtil.getInt;
import static com.dncomponents.northwind.dto.EncDecUtil.setInt;


@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class SupplierDTO {

    String company_name;
    String contact_name;
    String contact_title;
    String address;
    String city;
    String region;
    String postal_code;
    String country;
    String phone;
    String email;
    String homepage;
    private Double supplier_id;

    public final @JsOverlay
    Integer getSupplier_id() {
        return getInt(supplier_id);
    }

    public final @JsOverlay
    void setSupplier_id(Integer supplier_id) {
        this.supplier_id = setInt(supplier_id);
    }

    public final @JsOverlay
    String getCompany_name() {
        return company_name;
    }

    public final @JsOverlay
    void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public final @JsOverlay
    String getContact_name() {
        return contact_name;
    }

    public final @JsOverlay
    void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public final @JsOverlay
    String getContact_title() {
        return contact_title;
    }

    public final @JsOverlay
    void setContact_title(String contact_title) {
        this.contact_title = contact_title;
    }

    public final @JsOverlay
    String getAddress() {
        return address;
    }

    public final @JsOverlay
    void setAddress(String address) {
        this.address = address;
    }

    public final @JsOverlay
    String getCity() {
        return city;
    }

    public final @JsOverlay
    void setCity(String city) {
        this.city = city;
    }

    public final @JsOverlay
    String getRegion() {
        return region;
    }

    public final @JsOverlay
    void setRegion(String region) {
        this.region = region;
    }

    public final @JsOverlay
    String getPostal_code() {
        return postal_code;
    }

    public final @JsOverlay
    void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public final @JsOverlay
    String getCountry() {
        return country;
    }

    public final @JsOverlay
    void setCountry(String country) {
        this.country = country;
    }

    public final @JsOverlay
    String getPhone() {
        return phone;
    }

    public final @JsOverlay
    void setPhone(String phone) {
        this.phone = phone;
    }

    public final @JsOverlay
    String getEmail() {
        return email;
    }

    public final @JsOverlay
    void setEmail(String email) {
        this.email = email;
    }

    public final @JsOverlay
    String getHomepage() {
        return homepage;
    }

    public final @JsOverlay
    void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public final @JsOverlay
    SupplierDTOWrapper wrap() {
        return new SupplierDTOWrapper(this);
    }

}
