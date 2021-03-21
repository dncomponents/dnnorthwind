package com.dncomponents.northwind.model;

import com.dncomponents.northwind.dto.EmployeeDTO;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;
    private String last_name;
    private String first_name;
    private String title;
    private String title_of_courtesy;
    private Date birth_date;
    private Date hire_date;
    private String address;
    private String city;
    private String region;
    private String postal_code;
    private String country;
    private String home_phone;
    private String extension;
    private String photo;
    private Integer reports_to;

    public static void main(String[] args) {
        EmployeeDTO dto = new EmployeeDTO();
        Employee employee = new Employee();
        dto.setBirth_date(new Date());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, employee);
        System.out.println(dto.getBirth_date().equals(employee.birth_date));
        int i = 0;
        i++;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_of_courtesy() {
        return title_of_courtesy;
    }

    public void setTitle_of_courtesy(String title_of_courtesy) {
        this.title_of_courtesy = title_of_courtesy;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getReports_to() {
        return reports_to;
    }

    public void setReports_to(Integer reports_to) {
        this.reports_to = reports_to;
    }

}
