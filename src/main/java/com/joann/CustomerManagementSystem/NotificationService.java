package com.joann.CustomerManagementSystem;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendEmail(String email, String message) {
        System.out.println("Sending email to " + email + ": " + message);
    }
}
