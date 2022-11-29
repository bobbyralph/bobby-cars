package com.bobby;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PagesController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getHomePage() throws Exception {

        return "redirect:/index.html";

    }


}
