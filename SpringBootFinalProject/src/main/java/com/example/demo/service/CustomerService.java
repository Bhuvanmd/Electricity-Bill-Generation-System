package com.example.demo.service;



import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer updateCustomer(Long id, Customer customerDetails);
    void deleteCustomer(Long id);
    Customer loginCustomer(Customer customer);
}
