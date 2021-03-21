package com.dncomponents.northwind.dto;

import java.util.Date;


public class EmployeeDTOWrapper implements Comparable {

    public EmployeeDTO employeeDTO;

    public EmployeeDTOWrapper(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeDTOWrapper that = (EmployeeDTOWrapper) o;

        return this.getEmployee_id().equals(that.getEmployee_id());
    }

    @Override
    public int hashCode() {
        return this.getEmployee_id().hashCode();
    }

    public Integer getEmployee_id() {
        return employeeDTO.getEmployee_id();
    }

    public void setEmployee_id(Integer employee_id) {
        employeeDTO.setEmployee_id(employee_id);
    }

    public String getLast_name() {
        return employeeDTO.getLast_name();
    }

    public void setLast_name(String last_name) {
        employeeDTO.setLast_name(last_name);
    }

    public String getFirst_name() {
        return employeeDTO.getFirst_name();
    }

    public void setFirst_name(String first_name) {
        employeeDTO.setFirst_name(first_name);
    }

    public String getTitle() {
        return employeeDTO.getTitle();
    }

    public void setTitle(String title) {
        employeeDTO.setTitle(title);
    }

    public String getTitle_of_courtesy() {
        return employeeDTO.getTitle_of_courtesy();
    }

    public void setTitle_of_courtesy(String title_of_courtesy) {
        employeeDTO.setTitle_of_courtesy(title_of_courtesy);
    }

    public Date getBirth_date() {
        return employeeDTO.getBirth_date();
    }

    public void setBirth_date(Date birth_date) {
        employeeDTO.setBirth_date(birth_date);
    }

    public Date getHire_date() {
        return employeeDTO.getHire_date();
    }

    public void setHire_date(Date hire_date) {
        employeeDTO.setHire_date(hire_date);
    }

    public String getAddress() {
        return employeeDTO.getAddress();
    }

    public void setAddress(String address) {
        employeeDTO.setAddress(address);
    }

    public String getCity() {
        return employeeDTO.getCity();
    }

    public void setCity(String city) {
        employeeDTO.setCity(city);
    }

    public String getRegion() {
        return employeeDTO.getRegion();
    }

    public void setRegion(String region) {
        employeeDTO.setRegion(region);
    }

    public String getPostal_code() {
        return employeeDTO.getPostal_code();
    }

    public void setPostal_code(String postal_code) {
        employeeDTO.setPostal_code(postal_code);
    }

    public String getCountry() {
        return employeeDTO.getCountry();
    }

    public void setCountry(String country) {
        employeeDTO.setCountry(country);
    }

    public String getHome_phone() {
        return employeeDTO.getHome_phone();
    }

    public void setHome_phone(String home_phone) {
        employeeDTO.setHome_phone(home_phone);
    }

    public String getExtension() {
        return employeeDTO.getExtension();
    }

    public void setExtension(String extension) {
        employeeDTO.setExtension(extension);
    }

    public String getPhoto() {
        return employeeDTO.getPhoto();
    }

    public void setPhoto(String photo) {
        employeeDTO.setPhoto(photo);
    }

    public Integer getReports_to() {
        return employeeDTO.getReports_to();
    }

    public void setReports_to(Integer reports_to) {
        employeeDTO.setReports_to(reports_to);
    }

    public EmployeeDTO unWrap() {
        return employeeDTO;
    }

    @Override
    public String toString() {
        return getFirst_name() + ", " + getLast_name();
    }

    @Override
    public int compareTo(Object o) {
        return this.getEmployee_id().compareTo(((EmployeeDTOWrapper) o).getEmployee_id());
    }

}
