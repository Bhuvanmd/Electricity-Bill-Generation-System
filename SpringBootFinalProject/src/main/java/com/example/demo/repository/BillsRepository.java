package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Bills;

@Repository
public interface BillsRepository extends JpaRepository<Bills, Long> {
    List<Bills> findByCustomerCustomerId(Long billCustId);
}

