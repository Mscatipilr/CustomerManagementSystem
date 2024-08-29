package com.joann.CustomerManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private List<Customer> customerDatabase = new ArrayList<>();

    private NotificationService notificationService;

    @Autowired
    public CustomerServiceImpl(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDatabase.add(customer);
        notificationService.sendEmail(customer.getEmail(), "You have been added to the database!");
    }

    @Override
    public Customer getCustomer(Long id) {
        Optional<Customer> customer = customerDatabase.stream().filter(c -> c.getId().equals(id)).findFirst();
        return customer.orElse(null);
    }

    @Override
    public void updateCustomer(Customer customer) {
        for (Customer existingCustomer : customerDatabase) {
            if (existingCustomer.getId().equals(customer.getId())) {
                existingCustomer.setName(customer.getName());
                existingCustomer.setEmail(customer.getEmail());
                existingCustomer.setContactNumber(customer.getContactNumber());
                notificationService.sendEmail(customer.getEmail(), "Your information has been updated!");
                return;
            }
        }
        System.out.println("Customer with ID " + customer.getId() + " not found.");
    }


    @Override
    public void deleteCustomer(Long id) {
        // Find the customer with the given id
        Optional<Customer> customerToDelete = customerDatabase.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
        if (customerToDelete.isPresent()) {
            // Get the name of the customer before deletion
            String deletedCustomerName = customerToDelete.get().getName();

            // Remove the customer from the database
            customerDatabase.removeIf(customer -> customer.getId().equals(id));

            // Print confirmation message
            System.out.println("Customer " + deletedCustomerName + ", with ID " + id + " has been deleted.");
        } else {
            System.out.println("Customer with ID " + id + " not found.");
        }
    }

}
