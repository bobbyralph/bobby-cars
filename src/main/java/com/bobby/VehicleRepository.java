package com.bobby;

import com.bobby.entities.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
    Page<Vehicle> findAllBy(Pageable pageable);
    @Query(value = "SELECT distinct brand FROM vehicle", nativeQuery = true)
    List<String> findAllByDistinctBrand();
    @Query(value = "SELECT distinct model FROM vehicle where brand= :brand", nativeQuery = true)
    List<String> findDistinctByBrand(String brand);




}
