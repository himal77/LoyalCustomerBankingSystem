package com.rbinternational.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    @RequestMapping("/customerPanel")
    public String getCustomer() {
        return "customer/customerPanel";
    }
}
