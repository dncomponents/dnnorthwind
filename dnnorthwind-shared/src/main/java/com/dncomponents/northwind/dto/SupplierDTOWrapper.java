package com.dncomponents.northwind.dto;

public class SupplierDTOWrapper {

    private SupplierDTO supplierDTO;

    public SupplierDTOWrapper(SupplierDTO supplierDTO) {
        this.supplierDTO = supplierDTO;
    }

    public SupplierDTOWrapper() {
        this.supplierDTO = new SupplierDTO();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplierDTOWrapper that = (SupplierDTOWrapper) o;
//        return Objects.equals(supplierDTO.getSupplier_id(),that.getSupplier_id());
        return supplierDTO.getSupplier_id().equals(that.getSupplier_id());
    }

    @Override
    public int hashCode() {
        return supplierDTO.getSupplier_id().hashCode();
    }

    public Integer getSupplier_id() {
        return supplierDTO.getSupplier_id();
    }

    public void setSupplier_id(Integer supplier_id) {
        supplierDTO.setSupplier_id(supplier_id);
    }

    public String getCompany_name() {
        return supplierDTO.getCompany_name();
    }

    public void setCompany_name(String company_name) {
        supplierDTO.setCompany_name(company_name);
    }

    public String getContact_name() {
        return supplierDTO.getContact_name();
    }

    public void setContact_name(String contact_name) {
        supplierDTO.setContact_name(contact_name);
    }

    public String getContact_title() {
        return supplierDTO.getContact_title();
    }

    public void setContact_title(String contact_title) {
        supplierDTO.setContact_title(contact_title);
    }

    public String getAddress() {
        return supplierDTO.getAddress();
    }

    public void setAddress(String address) {
        supplierDTO.setAddress(address);
    }

    public String getCity() {
        return supplierDTO.getCity();
    }

    public void setCity(String city) {
        supplierDTO.setCity(city);
    }

    public String getRegion() {
        return supplierDTO.getRegion();
    }

    public void setRegion(String region) {
        supplierDTO.setRegion(region);
    }

    public String getPostal_code() {
        return supplierDTO.getPostal_code();
    }

    public void setPostal_code(String postal_code) {
        supplierDTO.setPostal_code(postal_code);
    }

    public String getCountry() {
        return supplierDTO.getCountry();
    }

    public void setCountry(String country) {
        supplierDTO.setCountry(country);
    }

    public String getPhone() {
        return supplierDTO.getPhone();
    }

    public void setPhone(String phone) {
        supplierDTO.setPhone(phone);
    }

    public String getEmail() {
        return supplierDTO.getEmail();
    }

    public void setEmail(String email) {
        supplierDTO.setEmail(email);
    }

    public String getHomepage() {
        return supplierDTO.getHomepage();
    }

    public void setHomepage(String homepage) {
        supplierDTO.setHomepage(homepage);
    }

    public SupplierDTO unWrap() {
        return supplierDTO;
    }

    @Override
    public String toString() {
        return supplierDTO.getCompany_name();
    }

}
