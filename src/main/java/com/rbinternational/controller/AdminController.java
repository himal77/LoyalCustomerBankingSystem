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

// This controller handles all of the 8 request mapping of admin

// registerAdmin
// adminPanel
// addCustomer
// checkCustomer
// registerCustomer
// deleteCustomerReq
// updateCustomerReq
// updateCustomer

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/registerAdmin", method = RequestMethod.POST)
    public String admin(@ModelAttribute Admin admin, Model model) {
        if (this.adminService.getAdmin(admin) != null) {
            model.addAttribute("msg", "User is already registered");
            return "admin/adminRegister";
        }
        if (this.adminService.addAdmin(admin) == 1) {
            model.addAttribute("msg", "admin registration successful");
            return "admin/adminRegister";
        }
        return "redirect:adminRegisterButton";
    }

    @RequestMapping(value = "/adminPanel", method = RequestMethod.POST)
    public String adminLoginPost(@ModelAttribute Admin admin, Model model) {
        if (this.adminService.getAdmin(admin) == null) {
            model.addAttribute("msg", "Invalid username or password");
            return "admin/adminLogin";
        }
        model.addAttribute("userName", admin.getUserName());
        model.addAttribute("kennwort", admin.getKennwort());
        model.addAttribute("admin", admin);
        return "admin/adminPanel";
    }


    @RequestMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("admin") Admin admin, Model model) {
        model.addAttribute("admin", admin);
        return "admin/addCustomer";
    }

    @RequestMapping("/checkCustomer")
    public String checkCustomer(@ModelAttribute("admin") Admin admin, Model model) {
        List<Customer> customerList = adminService.getCustomerList();
        model.addAttribute("customerList", customerList);
        model.addAttribute("admin", admin);
        return "admin/checkCustomer";
    }

    @RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
    public String registerCustomer(@ModelAttribute Customer customer, Model m, @ModelAttribute Admin admin) {
        m.addAttribute("admin", admin);
        if (adminService.getCustomer(customer.getAccountNo()) != null) {
            m.addAttribute("msg", "This customer is already registered!");
            return "admin/addCustomer";
        }


        adminService.addCustomer(customer);
        List<Customer> customerList = adminService.getCustomerList();
        m.addAttribute("customerList", customerList);
        return "admin/checkCustomer";

    }

    @RequestMapping("/deleteCustomerReq")
    public String deleteCustomer(@RequestParam("accountNo") int accountNo, @ModelAttribute Admin admin, Model model) {
        adminService.deleteCustomer(accountNo);
        model.addAttribute("admin", admin);
        List<Customer> customerList = adminService.getCustomerList();
        model.addAttribute("customerList", customerList);
        return "admin/checkCustomer";
    }

    @RequestMapping("/updateCustomerReq")
    public String updateCustomer(@RequestParam("accountNo") int accountNo, @ModelAttribute Admin admin, Model model) {
        Customer customer = adminService.getCustomer(accountNo);
        model.addAttribute("admin", admin);
        System.out.println(customer);
        model.addAttribute("customer", customer);
        return "admin/updateCustomer";
    }

    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public String updateCustomer(@ModelAttribute Customer customer, @ModelAttribute Admin admin, Model model) {
        adminService.updateCustomer(customer);
        model.addAttribute("admin", admin);
        List<Customer> customerList = adminService.getCustomerList();
        model.addAttribute("customerList", customerList);
        return "admin/checkCustomer";
    }
}
