package com.example.demo.serviceimpl;




import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Bills;
import com.example.demo.model.Customer;
import com.example.demo.repository.BillsRepository;
import com.example.demo.service.BillsService;
import com.example.demo.service.CustomerService;

@Service
public class BillsServiceImpl implements BillsService {

    private final BillsRepository billsRepository;
    private final CustomerService customerService;

    public BillsServiceImpl(BillsRepository billsRepository,CustomerService customerService) {
        this.billsRepository = billsRepository;
        this.customerService=customerService;
    }

    @Override
    public List<Bills> getAllBills() {
        return billsRepository.findAll();
    }

    @Override
    public List<Bills> getBillsByCustomerId(Long customerId) {
        return billsRepository.findByCustomerCustomerId(customerId);
    }

    @Override
    public Bills saveBill(Bills bill,long customerId ) {
    	Customer customer = customerService.getCustomerById(customerId);
    //	List<Customer> clist = new ArrayList();
    	//clist.add(customer);
    	bill.setCustomer(customer);
    	bill.setBillNum(customer.getMeterNo());
        return billsRepository.save(bill);
    }

    @Override
    public Bills getBillById(Long billId) {
        return billsRepository.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill not found with id: " + billId));
    }

    @Override
    public Bills updateBill(Long billId, Bills updatedBill) {
        Bills existingBill = getBillById(billId);
        existingBill.setCustomer(updatedBill.getCustomer());
        existingBill.setBillNum(updatedBill.getBillNum());
        existingBill.setBillDesc(updatedBill.getBillDesc());
        existingBill.setBillUnits(updatedBill.getBillUnits());
        existingBill.setAmount(updatedBill.getAmount());
        return billsRepository.save(existingBill);
    }

    @Override
    public void deleteBill(Long billId) {
        Bills bill = getBillById(billId);
        billsRepository.delete(bill);
    }
}
