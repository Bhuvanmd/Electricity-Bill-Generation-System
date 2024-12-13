package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Bills;
import com.example.demo.model.Customer;
import com.example.demo.model.Payment;
import com.example.demo.repository.BillsRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PaymentRepository;

@SpringBootTest
class SpringBootFinalProjectApplicationTests {
	@Autowired
	public CustomerRepository customerRepository;
	public PaymentRepository paymentRepository;
	public BillsRepository billsRepository;
	

	@Disabled
	@Test
	void contextLoads() {
		Customer customer =new Customer();
		customer.setCustomerName("bhuvan");
		customer.setAddress("hassan");
		customer.setContactNo("99876567876");
		customer.setEmail("bhuvanmd7221@gmail.com");
		customer.setMeterNo("C442024106");
		customer.setPassword("13243");
		assertNotNull(customerRepository.save(customer));
	}
	
	@Disabled
	@Test
	void testCustomerGetById() {
		long num=1;
		assertNotNull(customerRepository.findById(num));
	}
	@Disabled
	@Test
	void paymentCheck() {
		Payment payment=new Payment();
		long num1=5;
		payment.setBillId(num1);
		
		payment.setAmount(5000);
		payment.setBillNum("C442024106");
		payment.setPaymentStatus("paid");
	}
	
	@Test
	void billCheck() {
		Bills bills=new Bills();
		bills.setBillNum("C442024106");
		bills.setBillDesc("Electricity Bill");
		bills.setAmount(19202.00);
		
	}
	
	
	
}

	
