package com.opencart.Controller;

import com.opencart.Service.OpenCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SearchController {
    private OpenCartService openCartService;

    @Autowired
    public SearchController(OpenCartService openCartService){
        this.openCartService = openCartService;
    }

}
