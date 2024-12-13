// src/app/components/payment/payment.component.ts

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BillsService } from '../../services/bills.service';
import { Payment } from '../../payment';  // Import the Payment model
import { Bill } from '../../bills'; // Import the Bill model

import jsPDF from 'jspdf';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  billId: any;
  payment: Payment;  // Using the Payment model
  
  upiId: string = '';
  errorMessage: string = '';
  enteredOtp: string = '';
  paymentStatus: string = '';
  generatedOtp: string = ''; // Store the OTP for comparison

  constructor(
    private activatedRoute: ActivatedRoute,
    private billsService: BillsService,
    private router: Router
  ) {
    // Initialize the payment object with default values
    this.payment = new Payment(0, 0, 0, '', '', 0); 
  }

  ngOnInit(): void {
    // Get the billId from the route parameter
    this.billId = this.activatedRoute.snapshot.params['billId'];

    //if (this.billId) {
      this.fetchBillDetails(this.billId);
   // } else {
     // console.error('Bill ID is undefined!');
    //}
  }

  fetchBillDetails(billId: any): void {
    // Call the BillsService to fetch the bill details by billId
    this.billsService.getBillById(billId).subscribe(
      (billData: Bill) => {
        // Assuming the bill has the same fields as the Payment model
        this.payment.billNum = billData.billNum;
        this.payment.billUnits = billData.billUnits;
        this.payment.billId = billData.billId;
        this.payment.amount = billData.amount;
        this.payment.paymentStatus = 'Pending';  // Default status is Pending
      },
      (error: any) => {
        console.error('Error fetching bill details:', error);
      }
    );
  }

  makePayment() {
    
    // Step 1: Prompt the user to enter their UPI ID
    const upiInput = prompt("Enter your UPI ID for payment (e.g., 1234567890@xyz):");
  
    // Validate the UPI ID format
    const upiRegex = /^[A-Za-z0-9]+@[A-Za-z]+$/;
    if (!upiInput || !upiRegex.test(upiInput)) {
      alert("Invalid UPI ID. Please enter a valid UPI ID in the format 1234567890@provider.");
      return;
    }
  
    // Save the valid UPI ID
    this.upiId = upiInput;
  
    // Step 2: Generate OTP and store it in the variable
    this.generatedOtp = Math.floor(100000 + Math.random() * 900000).toString();
    console.log("Generated OTP:", this.generatedOtp); // Debugging: Check the console for the generated OTP
  
    // Step 3: Simulate OTP being sent to the user's phone
    
    alert("OTP is "+this.generatedOtp);
    // Step 4: Prompt the user to enter the OTP
    const enteredOtp = prompt("Enter the OTP:");
   

  
    // Step 5: Validate the entered OTP
    if (enteredOtp !== this.generatedOtp) {
      alert("Invalid OTP. Payment failed. Please try again.");
      return;
    }
  
    // Step 6: If OTP is valid, proceed with payment
    this.payment.paymentStatus = "Paid";
  
    this.billsService.updateBill(this.payment).subscribe(
      (response: any) => {
        console.log("Payment successful:", response);
        alert("Payment successful with UPI ID: " + upiInput);
        this.router.navigate(["/home"]);
      },
      (error: any) => {
        console.error("Error during payment:", error);
        alert("Payment failed. Please try again.");
        this.payment = new Payment(0, 0, 0, '', '', 0);
      }
    );
  }
  
  generatePDF() {

    if (this.payment.paymentStatus !== 'Paid') {
      alert("You cannot download the bill PDF until the payment is completed.");
      return;
    }
    const doc = new jsPDF();

   

    // Add bill details to the PDF
    doc.setFontSize(18);
    doc.text('Electricity Bill', 10, 10);

    doc.setFontSize(12);
    doc.text(`Bill Number: ${this.payment.billNum}`, 10, 30);
    doc.text(`Bill Units: ${this.payment.billUnits}`, 10, 40);
    doc.text(`Amount in Rupees: ${this.payment.amount}`, 10, 50);
    doc.text(`Payment Status: ${this.payment.paymentStatus}`, 10, 60);
    doc.text(`Bill ID: ${this.payment.billId}`, 10, 70);


   

    // Save the PDF
    doc.save(`Bill_${this.payment.billNum}.pdf`);
  }
}



