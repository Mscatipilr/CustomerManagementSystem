package com.joann.CustomerManagementSystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService customerService = context.getBean(CustomerService.class);

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Joann Ellis");
        customer.setEmail("foobar@hotmail.com");
        customer.setContactNumber("9882349876");

        customerService.addCustomer(customer);

        Customer retrievedCustomer = customerService.getCustomer(1L);
        System.out.println("Retrieved Customer: " + retrievedCustomer.getName());

        customerService.deleteCustomer(1L);
    }
}
