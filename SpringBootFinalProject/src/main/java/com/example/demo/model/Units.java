package com.example.demo.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "units")
public class Units {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "units_id")
    private Long unitsId;

    @Column(name = "units_type", nullable = false)
    private String unitsType;

    @Column(name = "units_desc", nullable = false)
    private String unitsDesc;

    // Default constructor
    public Units() {
    }

    // Constructor with parameters
    public Units(String unitsType, String unitsDesc) {
        this.unitsType = unitsType;
        this.unitsDesc = unitsDesc;
    }

    // Getters and Setters
    public Long getUnitsId() {
        return unitsId;
    }

    public void setUnitsId(Long unitsId) {
        this.unitsId = unitsId;
    }

    public String getUnitsType() {
        return unitsType;
    }

    public void setUnitsType(String unitsType) {
        this.unitsType = unitsType;
    }

    public String getUnitsDesc() {
        return unitsDesc;
    }

    public void setUnitsDesc(String unitsDesc) {
        this.unitsDesc = unitsDesc;
    }

    @Override
    public String toString() {
        return "Units{" +
                "unitsId=" + unitsId +
                ", unitsType='" + unitsType + '\'' +
                ", unitsDesc='" + unitsDesc + '\'' +
                '}';
    }
}
