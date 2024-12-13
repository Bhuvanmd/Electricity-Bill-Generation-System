package com.example.demo.service;



import java.util.List;

import com.example.demo.model.Units;

public interface UnitsService {
    Units saveUnits(Units units);
    List<Units> getAllUnits();
    Units getUnitsById(Long id);
    Units updateUnits(Long id, Units unitsDetails);
    void deleteUnits(Long id);
}
