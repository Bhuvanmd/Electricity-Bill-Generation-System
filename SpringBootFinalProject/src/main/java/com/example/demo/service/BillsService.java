package com.example.demo.service;





import java.util.List;

import com.example.demo.model.Bills;

public interface BillsService {
    List<Bills> getAllBills(); // Fetch all bills
    List<Bills> getBillsByCustomerId(Long customerId); // Fetch bills by customer ID
    Bills saveBill(Bills bill,long customerId); // Create or update a bill
    Bills getBillById(Long billId); // Get a specific bill by ID
    Bills updateBill(Long billId, Bills updatedBill); // Update a bill
    void deleteBill(Long billId); // Delete a bill
}
