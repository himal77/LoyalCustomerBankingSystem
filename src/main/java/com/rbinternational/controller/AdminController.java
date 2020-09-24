package com.rbinternational.controller;

import com.rbinternational.model.Admin;
import com.rbinternational.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/registerAdmin", method = RequestMethod.POST)
    public String admin(@ModelAttribute Admin admin) {
        if(this.adminService.addAdmin(admin) == 1) return "redirect:adminButton";
        return "redirect:adminRegisterButton";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String adminLogin(@ModelAttribute Admin admin) {
        if(this.adminService.getAdmin(admin) == null) return "redirect:adminButton";
        return "admin";
    }

    @RequestMapping("/addCustomer")
    public String addCustomer() {
        return "addCustomer";
    }

}
