package com.rbinternational.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @RequestMapping("/customer")
    public String getCustomer() {
        return "customer";
    }
}
