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
    public String admin(@ModelAttribute Admin admin, Model model) {
        if (this.adminService.getAdmin(admin) != null) {
            model.addAttribute("msg", admin.getUserName() + " is already registered");
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
        model.addAttribute("password", admin.getPassword());
        model.addAttribute("admin", admin);
        return "admin/adminPanel";
    }

    @RequestMapping(value = "/adminPanel", method = RequestMethod.GET)
    public String adminLoginPost() {
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
        List<Customer> customerList = adminService.getCustomerList();
        m.addAttribute("customerList", customerList);

        if (adminService.addCustomer(customer) == 1) {
            return "admin/checkCustomer";
        }
        m.addAttribute("msg", "Customer addition unsuccessful");
        return "message";
    }

    @RequestMapping("/deleteCustomerReq")
    public String deleteCustomer(@RequestParam("accountNo") int accountNo) {
        adminService.deleteCustomer(accountNo);
        return "redirect:checkCustomer";
    }

    @RequestMapping("/updateCustomerReq")
    public String updateCustomer(@RequestParam("accountNo") int accountNo, @ModelAttribute Admin admin, Model model) {
        Customer customer = adminService.getCustomer(accountNo);
        model.addAttribute("admin", admin);
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
