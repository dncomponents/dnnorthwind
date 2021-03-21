package com.dncomponents.northwind.dto;


public class CustomerDTOWrapper implements Comparable {

    private CustomerDTO customerDTO;

    public CustomerDTOWrapper(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public CustomerDTOWrapper() {
        this.customerDTO = new CustomerDTO();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDTOWrapper that = (CustomerDTOWrapper) o;

        return this.customerDTO.getCustomer_id().equals(that.getCustomer_id());
    }

    @Override
    public int hashCode() {
        return this.customerDTO.getCustomer_id().hashCode();
    }


    public Integer getCustomer_id() {
        return customerDTO.getCustomer_id();
    }

    public void setCustomer_id(Integer customer_id) {
        customerDTO.setCustomer_id(customer_id);
    }

    public String getCompany_name() {
        return customerDTO.getCompany_name();
    }

    public void setCompany_name(String company_name) {
        customerDTO.setCompany_name(company_name);
    }

    public String getContact_name() {
        return customerDTO.getContact_name();
    }

    public void setContact_name(String contact_name) {
        customerDTO.setContact_name(contact_name);
    }

    public String getContact_title() {
        return customerDTO.getContact_title();
    }

    public void setContact_title(String contact_title) {
        customerDTO.setContact_title(contact_title);
    }

    public String getAddress() {
        return customerDTO.getAddress();
    }

    public void setAddress(String address) {
        customerDTO.setAddress(address);
    }

    public String getCity() {
        return customerDTO.getCity();
    }

    public void setCity(String city) {
        customerDTO.setCity(city);
    }

    public String getRegion() {
        return customerDTO.getRegion();
    }

    public void setRegion(String region) {
        customerDTO.setRegion(region);
    }

    public String getPostal_code() {
        return customerDTO.getPostal_code();
    }

    public void setPostal_code(String postal_code) {
        customerDTO.setPostal_code(postal_code);
    }

    public String getCountry() {
        return customerDTO.getCountry();
    }

    public void setCountry(String country) {
        customerDTO.setCountry(country);
    }

    public String getPhone() {
        return customerDTO.getPhone();
    }

    public void setPhone(String phone) {
        customerDTO.setPhone(phone);
    }

    public String getEmail() {
        return customerDTO.getEmail();
    }

    public void setEmail(String email) {
        customerDTO.setEmail(email);
    }

    public CustomerDTO unWrap() {
        return customerDTO;
    }

    @Override
    public String toString() {
        return getCompany_name();
    }

    @Override
    public int compareTo(Object o) {
        return this.getCustomer_id().compareTo(((CustomerDTOWrapper) o).getCustomer_id());
    }

}
