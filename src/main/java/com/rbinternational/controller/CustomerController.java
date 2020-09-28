package com.rbinternational.controller;

import com.rbinternational.model.Customer;
import com.rbinternational.model.Transaction;
import com.rbinternational.service.CustomerService;
import com.rbinternational.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CustomerController {

    private Date lastTransactionDate = new Date();

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/customerPanel", method = RequestMethod.POST)
    public String getCustomer(@RequestParam("accountNo") int accountNo, @RequestParam("password") String password, Model model) {
        Customer customer = customerService.getCustomerByAccountNoAndPassword(accountNo, password);
        if (customer != null) {
            model.addAttribute("accountNo", customer.getAccountNo());
            return "customer/customerPanel";
        }
        return "redirect:customerButton";
    }

    @RequestMapping(value = "/transaction")
    public String doTransaction(@RequestParam("accountNo") int accountNo, Model model) {
       model.addAttribute("accountNo", accountNo);
       return "customer/transaction";
    }

    @RequestMapping("/withdrawal")
    public String withdrawal() {
        return "customer/withdrawal";
    }

    @RequestMapping("/deposit")
    public String deposit(@RequestParam("accountNo") int accountNo, Model model) {
        model.addAttribute("accountNo", accountNo);
        return "customer/deposit";
    }

    @RequestMapping("/transfer")
    public String transfer() {
        return "customer/transfer";
    }

    @RequestMapping("doDeposit")
    public String doDeposit(@RequestParam("amount") float amount,
                            @RequestParam("date") String date, @RequestParam("accountNo") int accountNo) {
        Date d = convertDate(date);
        Customer customer = customerService.getCustomer(accountNo);
        float previousAmount = customer.getCurrentBalance();
        customer.setCurrentBalance(previousAmount + amount);
        customerService.updateCustomer(customer);

        Transaction transaction = new Transaction(amount, d, "Deposit", customer, customer);
        transactionService.insertTransaction(transaction);

//        try {
//            long diff = d.getTime() - lastTransactionDate.getTime();
//            int durationFromLastTransaction = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return "customer/deposit";
    }

    @RequestMapping("doWithdrawal")
    public String doWithdrawal(@RequestParam("amount") float amount,
                            @RequestParam("date") String date, @RequestParam("accountNo") int accountNo) {

        Customer customer = customerService.getCustomer(accountNo);
        float previousAmount = customer.getCurrentBalance();
        customer.setCurrentBalance(previousAmount - amount);
        customerService.updateCustomer(customer);

        Transaction transaction = new Transaction(amount, d, "Deposit", customer, customer);
        transactionService.insertTransaction(transaction);

//        try {
//            long diff = d.getTime() - lastTransactionDate.getTime();
//            int durationFromLastTransaction = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return "customer/deposit";
    }

    public Date convertDate(String d) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
