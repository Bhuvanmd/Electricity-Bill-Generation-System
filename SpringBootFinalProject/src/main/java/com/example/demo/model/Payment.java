package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentId")
    private Long payId;

    @Column(name = "BillId")
    private Long billId;

    @Column(name = "Amount")
    private double amount;
    
    @Column(name="MeterNo")
    private String billNum;

    @Column(name = "PaymentStatus")
    private String paymentStatus;
    
   
    
    

	/**
	 * @return the payId
	 */
	public Long getPayId() {
		return payId;
	}

	/**
	 * @param payId the payId to set
	 */
	public void setPayId(Long payId) {
		this.payId = payId;
	}

	/**
	 * @return the billId
	 */
	public Long getBillId() {
		return billId;
	}

	/**
	 * @param billId the billId to set
	 */
	public void setBillId(Long billId) {
		this.billId = billId;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the meterNo
	 */
	

	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * @return the billNum
	 */
	public String getBillNum() {
		return billNum;
	}

	/**
	 * @param billNum the billNum to set
	 */
	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}

	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", billId=" + billId + ", amount=" + amount + ", billNum=" + billNum
				+ ", paymentStatus=" + paymentStatus + "]";
	}


    
}
    