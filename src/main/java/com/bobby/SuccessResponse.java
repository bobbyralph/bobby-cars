package com.bobby;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.HashMap;

@Data
public class SuccessResponse {
    Object data;
    Object extra;
    Object message;
    Boolean success = true;
    private static ObjectMapper OM = new ObjectMapper();

    public SuccessResponse(Page data, String message) {
        this.data = data.getContent();
        this.message = message;
        var pageData = OM.convertValue(data.getPageable(), HashMap.class);
        pageData.put("totalElements",data.getTotalElements());
        pageData.put("totalPages",data.getTotalPages());
        pageData.put("number",data.getNumber());
        pageData.put("numberOfElements",data.getNumberOfElements());
        this.extra = pageData;
    }


    public SuccessResponse(Object data, String message) {

        this.data = data;
        this.message = message;
    }


}
