# Customer Management System

## Overview

This project is a simple Customer Management System built using Spring Framework. It demonstrates core concepts such as Inversion of Control (IoC), Dependency Injection (DI), and bean management within the Spring ecosystem. The system includes functionalities for adding, retrieving, updating, and deleting customer information, along with a notification service for sending email notifications.

## Project Setup

### Build Tool: Maven

We chose **Maven** as the build tool for this project due to its widespread use in the Java ecosystem, excellent support for dependency management, and seamless integration with popular IDEs like IntelliJ IDEA and Eclipse. Maven's large repository of libraries and plugins makes it a robust choice for managing the project's dependencies and build lifecycle.

### Dependencies

The following dependencies are included in the `pom.xml` file:

- **Spring Core**: Provides fundamental parts of the Spring Framework.
- **Spring Beans**: Offers the BeanFactory, a sophisticated implementation of the factory pattern.
- **Spring Context**: Provides ApplicationContext, an advanced container for Spring Beans.
- **Spring Expression Language**: Used for querying and manipulating an object graph at runtime.

These dependencies are included by adding the `Spring Boot Starter Web` and other necessary Spring Boot starters, which automatically bring in the required libraries.

## Designing the System

### Customer Class

The `Customer` class represents the customer entity with attributes such as:

- `id`: A unique identifier for the customer.
- `name`: The name of the customer.
- `email`: The customer's email address.
- `contactNumber`: The customer's contact number.

The `Customer` class is annotated with `@Component` to make it a Spring bean, enabling it to be managed by the Spring IoC container.

### CustomerService Interface

The `CustomerService` interface defines the operations for managing customers:

- `addCustomer(Customer customer)`: Adds a new customer.
- `getCustomer(Long id)`: Retrieves a customer by their ID.
- `updateCustomer(Customer customer)`: Updates the customer's information.
- `deleteCustomer(Long id)`: Deletes a customer by their ID.

### CustomerServiceImpl Class

The `CustomerServiceImpl` class implements the `CustomerService` interface. It uses a `List<Customer>` to simulate a database for storing customer data. The `NotificationService` is injected via constructor injection to send email notifications when a new customer is added.

### NotificationService

The `NotificationService` class is responsible for sending email notifications. For the sake of this project, the email functionality is simulated with a simple print statement.

## IoC and Dependency Injection

This project demonstrates the use of Inversion of Control (IoC) and Dependency Injection (DI) through the following mechanisms:

- **Setter Injection**: Injecting dependencies via setter methods.
- **Constructor Injection**: Injecting dependencies via constructors.
- **@Autowired Annotation**: Used to automatically inject dependencies.

The `CustomerServiceImpl` class uses constructor injection to receive a `NotificationService` instance, ensuring that dependencies are properly managed by the Spring IoC container.

## Testing the System

### MainApp Class

The `MainApp` class contains the `main` method, which serves as the entry point for the application. It retrieves the `CustomerService` bean from the Spring IoC container and performs CRUD operations on `Customer` objects. The operations include:

- Adding a new customer.
- Retrieving a customer by ID.
- Updating a customer's information.
- Deleting a customer by ID.

When a new customer is added, the `NotificationService` sends an email (simulated with a print statement).

## Challenges Faced

One of the main challenges was understanding the configuration and usage of the Spring IoC container, particularly in terms of how dependencies are managed and injected. Another challenge was ensuring that the mock database (a simple list) accurately simulated the behavior of a real database.

## Assumptions

- The project uses a simple list as a mock database instead of a real database.
- The email notification functionality is simulated with a print statement.
- The `Customer` class is managed as a Spring bean to leverage Spring's IoC capabilities.

## Conclusion

This project serves as a basic example of using Spring Framework for developing a simple application with core functionalities like IoC, DI, and bean management. It lays the foundation for building more complex applications with real-world databases and services.
