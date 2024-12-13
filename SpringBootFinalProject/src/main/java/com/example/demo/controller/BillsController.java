package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Bills;
import com.example.demo.service.BillsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/bills")
public class BillsController {

    @Autowired
    private BillsService billsService;

    // Create a new Bill
    @PostMapping("/create/{customerId}")
    public ResponseEntity<Bills> createBill(@PathVariable("customerId") long customerId, @RequestBody Bills bill) {
        System.out.println("Received Bill: " + bill);
        Bills savedBill = billsService.saveBill(bill, customerId);
        return new ResponseEntity<>(savedBill, HttpStatus.CREATED);
    }

    // Get all Bills
    @GetMapping
    public ResponseEntity<List<Bills>> getAllBills() {
        List<Bills> billsList = billsService.getAllBills();
        return new ResponseEntity<>(billsList, HttpStatus.OK);
    }

    // Get Bills by Customer ID
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Bills>> getBillsByCustomerId(@PathVariable Long customerId) {
        List<Bills> billsList = billsService.getBillsByCustomerId(customerId);
        return new ResponseEntity<>(billsList, HttpStatus.OK);
    }

    // Get a single Bill by ID
    @GetMapping("/{billId}")
    public ResponseEntity<Bills> getBillById(@PathVariable Long billId) {
        Bills bill = billsService.getBillById(billId);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    // Update a Bill by ID
    @PutMapping("/{billId}")
    public ResponseEntity<Bills> updateBill(@PathVariable Long billId, @RequestBody Bills updatedBill) {
        Bills bill = billsService.updateBill(billId, updatedBill);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    // Delete a Bill by ID
    @DeleteMapping("/{billId}")
    public ResponseEntity<String> deleteBill(@PathVariable Long billId) {
        billsService.deleteBill(billId);
        return new ResponseEntity<>("Bill with ID " + billId + " has been deleted successfully.", HttpStatus.OK);
    }
}
