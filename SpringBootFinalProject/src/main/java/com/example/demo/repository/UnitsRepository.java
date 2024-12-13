package com.example.demo.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Units;

@Repository
public interface UnitsRepository extends JpaRepository<Units, Long> {
    // You can add custom queries here if needed
}
