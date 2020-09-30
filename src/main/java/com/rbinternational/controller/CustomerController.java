package com.rbinternational.controller;

import com.rbinternational.model.Customer;
import com.rbinternational.model.Transaction;
import com.rbinternational.service.CustomerService;
import com.rbinternational.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

// This is for customer
// It handles six mapping

// customerPanel
// transaction
// withdrawal
// deposit
// transfer
// viewTransaction

// All the mapping here is for view purpose,
// withdrawal, deposit, transfer is used to display the form for doing transaction
// viewTransaction is the main mapping in this controller,
// Which display the history of transaction of the customer

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;


    // It display customer panel
    // viewPoints, viewPointsHistory, Transaction and doTransaction
    @RequestMapping(value = "/customerPanel", method = RequestMethod.POST)
    public String getCustomer(@RequestParam("accountNo") int accountNo, @RequestParam("password") String password, Model model) {
        Customer customer = customerService.getCustomerByAccountNoAndPassword(accountNo, password);
        if (customer != null) {
            model.addAttribute("accountNo", customer.getAccountNo());
            return "customer/customerPanel";
        }
        return "redirect:customerButton";
    }

    // It display which types of transaction you want to perform
    // withdrawal, deposit, transfer
    @RequestMapping(value = "/transaction")
    public String doTransaction(@RequestParam("accountNo") int accountNo, Model model) {
        model.addAttribute("accountNo", accountNo);
        model.addAttribute("password", customerService.getCustomer(accountNo).getPassword());
        return "customer/transaction";
    }

    // Display withdrawal form
    @RequestMapping("/withdrawal")
    public String withdrawal(@RequestParam("accountNo") int accountNo, Model model) {
        model.addAttribute("accountNo", accountNo);
        // model.addAttribute("msg", "This is the message");
        return "customer/withdrawal";
    }

    // Display deposit from
    @RequestMapping("/deposit")
    public String deposit(@RequestParam("accountNo") int accountNo, Model model) {
        model.addAttribute("accountNo", accountNo);
        return "customer/deposit";
    }

    // Display transfer form
    @RequestMapping("/transfer")
    public String transfer(@RequestParam("accountNo") int accountNo, Model model) {
        model.addAttribute("accountNo", accountNo);
        return "customer/transfer";
    }

    // View transaction handler or controller
    @RequestMapping("/viewTransaction")
    public String viewTransaction(@RequestParam("accountNo") int accountNo, Model model) {

        Customer customer = customerService.getCustomer(accountNo);
        List<Transaction> receivedTransactionList = transactionService.getReceivedTransactionList(customer);
        List<Transaction> sentTransactionList = transactionService.getSentTransactionList(customer);

        float outgoing = 0.0f;
        float incoming = 0.0f;

        for (Transaction t : sentTransactionList) {
            if(t.getType().equals("Deposit")) {
                incoming += t.getAmount();
            } else {
                outgoing += t.getAmount();
            }
        }

        for (Transaction t : receivedTransactionList) {
            incoming += t.getAmount();      // Received from another account
        }

        // Combining both transaction
        List<Transaction> transactionList = new ArrayList<>(sentTransactionList);
        transactionList.addAll(receivedTransactionList);

        // Setting attributes for view page to display
        model.addAttribute("transactionList", transactionList);
        model.addAttribute("accountNo", accountNo);
        model.addAttribute("password", customerService.getCustomer(accountNo).getPassword());
        model.addAttribute("currentBalance", customer.getCurrentBalance());
        model.addAttribute("incoming", incoming);
        model.addAttribute("outgoing", outgoing);

        return "customer/viewTransaction";
    }

}
