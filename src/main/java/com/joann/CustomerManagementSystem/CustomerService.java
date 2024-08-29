package com.joann.CustomerManagementSystem;

public interface CustomerService {
    void addCustomer(Customer customer);
    Customer getCustomer(Long id);
    void updateCustomer(Customer customer);
    void deleteCustomer(Long id);
}
