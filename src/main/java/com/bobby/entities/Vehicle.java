package com.bobby.entities;

import com.bobby.enums.VehicleAvailability;
import com.bobby.enums.VehicleType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int year = 2000;
    private int mileage = 0;
    private boolean used = false;
    private String brand;
    private String model;
    private String trim = "base";
    private String color;
    private VehicleType type=VehicleType.SEDAN;
    private VehicleAvailability availability = VehicleAvailability.AVAILABLE;

    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime modifiedOn;
    
	public Vehicle() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public VehicleAvailability getAvailability() {
		return availability;
	}

	public void setAvailability(VehicleAvailability availability) {
		this.availability = availability;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", year=" + year + ", mileage=" + mileage + ", used=" + used + ", brand=" + brand
				+ ", model=" + model + ", trim=" + trim + ", color=" + color + ", type=" + type + ", availability="
				+ availability + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + "]";
	}
	

    
}
