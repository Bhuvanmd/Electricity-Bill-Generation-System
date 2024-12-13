package com.example.demo.model;






import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bills")
public class Bills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billId;

    @Column(name = "bill_num", nullable = false)
    private String billNum;

    @Column(name = "bill_desc", nullable = false)
    private String billDesc;

    @Column(name = "bill_units", nullable = false)
    private Integer billUnits;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Default constructor
    public Bills() {
    }

    // Getters and Setters
    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public String getBillDesc() {
        return billDesc;
    }

    public void setBillDesc(String billDesc) {
        this.billDesc = billDesc;
    }

    public Integer getBillUnits() {
        return billUnits;
    }

    public void setBillUnits(Integer billUnits) {
        this.billUnits = billUnits;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

	

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Bills [billId=" + billId + ", billNum=" + billNum + ", billDesc=" + billDesc + ", billUnits="
				+ billUnits + ", amount=" + amount + ", customer=" + customer + "]";
	}


   
//    public Long getCustomerIdFromCustomer() {
		/*
		 * if (this.customer != null) { return this.customer.getCustomerId(); } return
		 * null; // Return null if no customer is associated
		     }*/

  
    
}
