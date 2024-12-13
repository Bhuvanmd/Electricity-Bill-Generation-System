package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Units;
import com.example.demo.service.UnitsService;

@RestController
@RequestMapping("/api/units")
public class UnitsController {

    @Autowired
    private UnitsService unitsService;

    // Create a new Unit
    @PostMapping
    public ResponseEntity<Units> createUnit(@RequestBody Units units) {
        return ResponseEntity.ok(unitsService.saveUnits(units));
    }

    // Get all Units
    @GetMapping
    public ResponseEntity<List<Units>> getAllUnits() {
        return ResponseEntity.ok(unitsService.getAllUnits());
    }

    // Get Unit by ID
    @GetMapping("/{id}")
    public ResponseEntity<Units> getUnitById(@PathVariable Long id) {
        return ResponseEntity.ok(unitsService.getUnitsById(id));
    }

    // Update a Unit by ID
    @PutMapping("/{id}")
    public ResponseEntity<Units> updateUnit(@PathVariable Long id, @RequestBody Units unitsDetails) {
        return ResponseEntity.ok(unitsService.updateUnits(id, unitsDetails));
    }

    // Delete a Unit by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUnit(@PathVariable Long id) {
        unitsService.deleteUnits(id);
        return ResponseEntity.ok("Unit with ID " + id + " deleted successfully.");
    }
}
