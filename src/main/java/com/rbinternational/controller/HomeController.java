package com.rbinternational.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/customerButton")
    public String customer() {
        return "customerLogin";
    }

    @RequestMapping("/adminButton")
    public String adminLogin() {
        return "adminLogin";
    }

    @RequestMapping("/adminRegisterButton")
    public String adminRegister() {
        return "adminRegister";
    }

}
