package com.example.demo.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Save a new Customer
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get all Customers
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get a Customer by ID
    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }

    // Update an existing Customer
    @Override
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));

        existingCustomer.setCustomerName(customerDetails.getCustomerName());
        existingCustomer.setAddress(customerDetails.getAddress());
        existingCustomer.setContactNo(customerDetails.getContactNo());
        existingCustomer.setEmail(customerDetails.getEmail());
        existingCustomer.setMeterNo(customerDetails.getMeterNo());

        return customerRepository.save(existingCustomer);
    }

    // Delete a Customer by ID
    @Override
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
        customerRepository.deleteById(id);
    }

	@Override
	public Customer loginCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmailAndPassword(customer.getEmail(),customer.getPassword());
	}
}
