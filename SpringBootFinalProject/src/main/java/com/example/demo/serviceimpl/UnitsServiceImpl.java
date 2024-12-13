package com.example.demo.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Units;
import com.example.demo.repository.UnitsRepository;
import com.example.demo.service.UnitsService;

@Service
public class UnitsServiceImpl implements UnitsService {

    @Autowired
    private UnitsRepository unitsRepository;

    // Save a new Unit
    @Override
    public Units saveUnits(Units units) {
        return unitsRepository.save(units);
    }

    // Get all Units
    @Override
    public List<Units> getAllUnits() {
        return unitsRepository.findAll();
    }

    // Get a Unit by ID
    @Override
    public Units getUnitsById(Long id) {
        return unitsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found with ID: " + id));
    }

    // Update an existing Unit
    @Override
    public Units updateUnits(Long id, Units unitsDetails) {
        Units existingUnit = unitsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found with ID: " + id));

        existingUnit.setUnitsType(unitsDetails.getUnitsType());
        existingUnit.setUnitsDesc(unitsDetails.getUnitsDesc());

        return unitsRepository.save(existingUnit);
    }

    // Delete a Unit by ID
    @Override
    public void deleteUnits(Long id) {
        if (!unitsRepository.existsById(id)) {
            throw new RuntimeException("Unit not found with ID: " + id);
        }
        unitsRepository.deleteById(id);
    }
}
