package com.rbinternational.controller;

import com.rbinternational.model.Customer;
import com.rbinternational.model.Points;
import com.rbinternational.model.PointsHistory;
import com.rbinternational.model.Transaction;
import com.rbinternational.service.CustomerService;
import com.rbinternational.service.PointsHistoryService;
import com.rbinternational.service.PointsService;
import com.rbinternational.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Controller
public class PointsController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private PointsService pointsService;

    @Autowired
    private PointsHistoryService pointsHistoryService;

    @RequestMapping("/doDeposit")
    public String doDeposit(@RequestParam("amount") float amount,
                            @RequestParam("date") String date,
                            @RequestParam("accountNo") int accountNo,
                            Model model) {
        Points points = pointsService.getPointOfCustomer(accountNo);
        Date d = convertDate(date);

        // To Stimulate real life banking system
        // Date cannot be older than last transaction date
        if (points != null) {
            if (compareDate(d, points.getLastDateOfTransaction()) < 0) {
                model.addAttribute("msg", "Please enter newer date from last transaction!");
                model.addAttribute("accountNo", accountNo);

                return "customer/deposit";
            }
        }

        // Adding balance to customer account
        Customer customer = customerService.getCustomer(accountNo);
        float previousAmount = customer.getCurrentBalance();
        customer.setCurrentBalance(previousAmount + amount);
        customerService.updateCustomer(customer);

        // Adding the transaction to transaction list
        Transaction transaction = new Transaction(amount, d, "Deposit", customer, customer);
        transactionService.insertTransaction(transaction);

        // Calculating points for the loyal customer
        calculatePointAndSave(points, amount, d, accountNo);

        // Displaying the successful transaction
        model.addAttribute("msg", "Successful Transaction");
        model.addAttribute("accountNo", accountNo);

        return "customer/deposit";
    }

    @RequestMapping("/doWithdrawal")
    public String doWithdrawal(@RequestParam("amount") float amount,
                               @RequestParam("date") String date,
                               @RequestParam("accountNo") int accountNo,
                               Model model) {
        Date d = convertDate(date);

        Customer customer = customerService.getCustomer(accountNo);
        float previousAmount = customer.getCurrentBalance();

        if (previousAmount < amount) {
            model.addAttribute("msg", "Unsuccessful Transaction, Amount Not Enough");
            model.addAttribute("accountNo", accountNo);
            return "customer/withdrawal";
        }

        customer.setCurrentBalance(previousAmount - amount);
        customerService.updateCustomer(customer);

        Transaction transaction = new Transaction(amount * -1, d, "Withdrawal", customer, customer);
        transactionService.insertTransaction(transaction);

        model.addAttribute("msg", "Successful Transaction");
        model.addAttribute("accountNo", accountNo);

        return "customer/withdrawal";
    }

    @RequestMapping("/doTransfer")
    public String doTransfer(@RequestParam("amount") float amount,
                             @RequestParam("date") String date,
                             @RequestParam("accountNo") int accountNo,
                             @RequestParam("toAccountNo") int toAccountNo,
                             Model model) {
        Date d = convertDate(date);

        Customer sender = customerService.getCustomer(accountNo);
        Customer receiver = customerService.getCustomer(toAccountNo);

        if (receiver == null) {
            model.addAttribute("msg", "No Customer With AccountNo " + toAccountNo);
            model.addAttribute("accountNo", accountNo);
            return "customer/transfer";
        }

        float previousAmount = sender.getCurrentBalance();

        if (previousAmount < amount) {
            model.addAttribute("msg", "Unsuccessful Transaction, Amount Not Enough");
            model.addAttribute("accountNo", accountNo);
            return "customer/transfer";
        }

        sender.setCurrentBalance(previousAmount - amount);
        receiver.setCurrentBalance(previousAmount + amount);

        customerService.updateCustomer(sender);
        customerService.updateCustomer(receiver);

        Transaction transaction = new Transaction(amount * -1, d, "Transfer", sender, receiver);
        transactionService.insertTransaction(transaction);

        model.addAttribute("msg", "Successful Transaction");
        model.addAttribute("accountNo", accountNo);

        return "customer/transfer";
    }

    // To convert the String date getting from form to Date of java.util
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

    // Comparing two dates with the day difference
    public int compareDate(Date d1, Date d2) {
        int durationFromLastTransaction = 0;
        try {
            long diff = d1.getTime() - d2.getTime();
            durationFromLastTransaction = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return durationFromLastTransaction;
    }

    // Viewing available or pending points
    @RequestMapping("/viewPoints")
    public String viewPoints(@RequestParam("accountNo") int accountNo, Model model) {
        Points points = pointsService.getPointOfCustomer(accountNo);
        model.addAttribute("points", points);
        model.addAttribute("accountNo", accountNo);
        model.addAttribute("password", customerService.getCustomer(accountNo).getPassword());
        return "customer/viewPoints";
    }

    // Calculating the points after each transaction and placing in points table
    public void calculatePointAndSave(Points points, float amount, Date date, int accountNo) {
        if (points == null) {
            points = new Points();
            float collectedPoint = calculatePoint(points.getTransactionTillNow(), amount, date, accountNo);
            System.out.println("This collect the point : " + collectedPoint);
        }
    }

    // Calculating the points after each transaction
    public float calculatePoint(float previousTransaction, float amount,  Date date, int accountNo) {
        if ((previousTransaction + amount) <= 5000.0) {
            // If less than 5000, giving single point for every amount and adding to point history table
            //pointsHistoryService.insert(new PointsHistory(date, amount, customerService.getCustomer(accountNo)));
            return amount;
        } else if ((previousTransaction + amount) <= 7500.0) {
            if (previousTransaction < 5000.0) {
                float total = 5000 - previousTransaction;
                total += ((previousTransaction + amount) - 5000) * 2;
                return total;
            } else {
                return amount * 2;
            }
        } else {
            if (previousTransaction > 7500) {
                return amount * 3;
            } else if (previousTransaction < 5000) {
                float total = 5000 - previousTransaction;
                total += (2500 * 2);
                total += ((previousTransaction + amount) - 7500) * 3;
                return total;
            } else {
                float total = (7500 - previousTransaction) * 2;
                total += ((previousTransaction + amount) - 7500) * 3;
                return total;
            }
        }
    }
}
