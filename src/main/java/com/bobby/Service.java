package com.bobby;


import com.bobby.entities.OOrder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Data
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
private final VehicleRepository vehicleRepository;
private final OrderRepository orderRepository;

    public Page getVehicles(int page, int size){
        return vehicleRepository.findAllBy(PageRequest.of(page, size));
    }
    public List getVehiclesBrands(){
        return vehicleRepository.findAllByDistinctBrand();
    }
    public List getVehiclesBrandModel(String brand){
        return vehicleRepository.findDistinctByBrand(brand);
    }

    public Page getOrders(int page, int size){
        return orderRepository.findAllBy(PageRequest.of(page, size));
    }

    public OOrder createOrder(OOrder OOrder){
        return orderRepository.save(OOrder);
    }



}


