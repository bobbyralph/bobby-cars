package com.bobby;

import com.bobby.entities.Vehicle;
import com.bobby.enums.VehicleAvailability;
import com.bobby.enums.VehicleType;
import lombok.Data;

@Data
public class VehicleParams {

    private int page = 0;
    private int size = 10;

    public void setPage(String param) {
        if (param == null || param.equals("")) {
            return;
        }
        page = Integer.parseInt(param);

    }

    public void setSize(String param) {
        if (param == null || param.equals("")) {
            return;
        }
        size = Integer.parseInt(param);

    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;


    }
}
