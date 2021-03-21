package com.dncomponents.northwind.dto;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

import java.util.Date;

import static com.dncomponents.northwind.dto.EncDecUtil.getInt;
import static com.dncomponents.northwind.dto.EncDecUtil.setInt;


@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class EmployeeDTO {

    Double employee_id;
    String last_name;
    String first_name;
    String title;
    String title_of_courtesy;
    Double birth_date;
    Double hire_date;
    String address;
    String city;
    String region;
    String postal_code;
    String country;
    String home_phone;
    String extension;
    String photo;
    Double reports_to;

    public final @JsOverlay
    Integer getEmployee_id() {
        return getInt(employee_id);
    }

    public final @JsOverlay
    void setEmployee_id(Integer employee_id) {
        this.employee_id = setInt(employee_id);
    }

    public final @JsOverlay
    String getLast_name() {
        return last_name;
    }

    public final @JsOverlay
    void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public final @JsOverlay
    String getFirst_name() {
        return first_name;
    }

    public final @JsOverlay
    void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public final @JsOverlay
    String getTitle() {
        return title;
    }

    public final @JsOverlay
    void setTitle(String title) {
        this.title = title;
    }

    public final @JsOverlay
    String getTitle_of_courtesy() {
        return title_of_courtesy;
    }

    public final @JsOverlay
    void setTitle_of_courtesy(String title_of_courtesy) {
        this.title_of_courtesy = title_of_courtesy;
    }

    public final @JsOverlay
    Date getBirth_date() {
        return birth_date == null ? null : new Date(birth_date.longValue());
    }

    public final @JsOverlay
    void setBirth_date(Date birth_date) {
        this.birth_date = birth_date == null ? null : (double) birth_date.getTime();
    }

    public final @JsOverlay
    Date getHire_date() {
        return hire_date == null ? null : new Date(hire_date.longValue());
    }

    public final @JsOverlay
    void setHire_date(Date hire_date) {
        this.hire_date = hire_date == null ? null : (double) hire_date.getTime();
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
    String getHome_phone() {
        return home_phone;
    }

    public final @JsOverlay
    void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public final @JsOverlay
    String getExtension() {
        return extension;
    }

    public final @JsOverlay
    void setExtension(String extension) {
        this.extension = extension;
    }

    public final @JsOverlay
    String getPhoto() {
        return photo;
    }

    public final @JsOverlay
    void setPhoto(String photo) {
        this.photo = photo;
    }

    public final @JsOverlay
    Integer getReports_to() {
        return getInt(reports_to);
    }

    public final @JsOverlay
    void setReports_to(Integer reports_to) {
        this.reports_to = setInt(reports_to);
    }

    @Override
    public final @JsOverlay
    String toString() {
        return first_name + ", " + last_name;
    }

    public final @JsOverlay
    EmployeeDTOWrapper wrap() {
        return new EmployeeDTOWrapper(this);
    }

}
