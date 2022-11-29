package com.bobby;


import com.bobby.entities.OOrder;
import com.bobby.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private  Service service;


    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public ResponseEntity getVehicle(VehicleParams params) throws Exception {

        Page<Vehicle> data = service.getVehicles(params.getPage(), params.getSize());
        return new ResponseEntity<SuccessResponse>(new SuccessResponse(data, "successful"), HttpStatus.OK);

    }
    @RequestMapping(value = "/vehicles/brands", method = RequestMethod.GET)
    public ResponseEntity getVehicleBrands() throws Exception {

        List<Vehicle> data = service.getVehiclesBrands();
        return new ResponseEntity<SuccessResponse>(new SuccessResponse(data, "successful"), HttpStatus.OK);

    }
    @RequestMapping(value = "/vehicles/models/{brand}", method = RequestMethod.GET)
    public ResponseEntity getVehicleBrandModel(@PathVariable String brand) throws Exception {

        List<String> data = service.getVehiclesBrandModel(brand);
        return new ResponseEntity<SuccessResponse>(new SuccessResponse(data, "successful"), HttpStatus.OK);

    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ResponseEntity getOrders(VehicleParams params) throws Exception {

        Page<Vehicle> data = service.getOrders(params.getPage(), params.getSize());
        return new ResponseEntity<SuccessResponse>(new SuccessResponse(data, "successful"), HttpStatus.OK);

    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public ResponseEntity createOrder(@RequestBody OOrder OOrder) throws Exception {

        OOrder data = service.createOrder(OOrder);
        return new ResponseEntity<SuccessResponse>(new SuccessResponse(data, "successful"), HttpStatus.OK);

    }


}
