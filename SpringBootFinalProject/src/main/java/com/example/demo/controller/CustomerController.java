package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/api/customers/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @PostMapping("signin")
    public ResponseEntity<Customer> loginCustomer(@RequestBody Customer customer) {
    	return new ResponseEntity<Customer>(customerService.loginCustomer(customer),HttpStatus.CREATED);
    }

    // Create a new Customer
    @PostMapping("signup")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    	return new ResponseEntity<Customer>(customerService.saveCustomer(customer),HttpStatus.CREATED);
    }

    // Get all Customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Get Customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
    	return new ResponseEntity<Customer>(customerService.getCustomerById(id),HttpStatus.OK);
    }

    // Update a Customer by ID
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
    	return new ResponseEntity<Customer>(customerService.updateCustomer(id,customerDetails),HttpStatus.OK);
    }

    // Delete a Customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<String>("Record deleted successfully",HttpStatus.OK);
    }

    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        // Validate the email and password
        Customer customer = customerService.getAllCustomers()
                .stream()
                .filter(c -> c.getEmail().equals(email) && c.getContactNo().equals(password)) // Using contactNo as password
                .findFirst()
                .orElse(null);

        if (customer == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        return ResponseEntity.ok("Login successful");
    }
}
