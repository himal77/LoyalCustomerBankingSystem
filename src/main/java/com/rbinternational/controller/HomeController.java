package com.rbinternational.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// This controller handler 3 mapping
// customerButton
// adminButton
// adminRegisterButton

// Displaying related page for admin, register admin and customer

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/customerButton")
    public String customer() {
        return "customer/customerLogin";
    }

    @RequestMapping("/adminButton")
    public String adminLogin() {
        return "admin/adminLogin";
    }

    @RequestMapping("/adminRegisterButton")
    public String adminRegister() {
        return "admin/adminRegister";
    }

}
