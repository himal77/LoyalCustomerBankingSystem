package com.rbinternational.controller;

import com.rbinternational.model.Admin;
import com.rbinternational.model.Customer;
import com.rbinternational.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/registerAdmin", method = RequestMethod.POST)
    public String admin(@ModelAttribute Admin admin) {
        if(this.adminService.addAdmin(admin) == 1) return "redirect:adminButton";
        return "redirect:adminRegisterButton";
    }

    @RequestMapping(value = "/adminPanel", method = RequestMethod.POST)
    public String adminLoginPost(@ModelAttribute Admin admin) {
        if(this.adminService.getAdmin(admin) == null) return "redirect:adminButton";
        return "admin/adminPanel";
    }

    @RequestMapping(value = "/adminPanel")
    public String adminLoginGet() {
        return "admin/adminPanel";
    }

    @RequestMapping("/addCustomer")
    public String addCustomer() {
        return "admin/addCustomer";
    }

    @RequestMapping("/checkCustomer")
    public String checkCustomer(Model model) {
        List<Customer> customerList = adminService.getCustomerList();
        model.addAttribute("customerList", customerList);
        return "admin/checkCustomer";
    }

    @RequestMapping("/adminLogout")
    public String adminLogout() {
        return "redirect:home";
    }

    @RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
    public String registerCustomer(@ModelAttribute Customer customer) {
        if(adminService.addCustomer(customer) == 1) return "redirect:adminPanel";
        return "redirect:addCustomer";
    }

    @RequestMapping("/deleteCustomerReq")
    public String deleteCustomer(@RequestParam("accountNo") int accountNo) {
        adminService.deleteCustomer(accountNo);
        return "redirect:checkCustomer";
    }

    @RequestMapping("/updateCustomerReq")
    public String updateCustomer(@RequestParam("accountNo") int accountNo, Model model) {
       Customer customer = adminService.getCustomer(accountNo);
       model.addAttribute("customer", customer);
        return "admin/updateCustomer";
    }

    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public String updateCustomer(@ModelAttribute Customer customer) {
        adminService.updateCustomer(customer);
        return "redirect:checkCustomer";
    }
}
