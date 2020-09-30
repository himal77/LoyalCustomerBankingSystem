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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

// This class maps four request
// doCollect
// collectPoints
// viewPoints
// viewPointsHistory

// doCollect is where the collection part is completed.
// All the requirement for collecting point is given here
// Here, it is also checked if the customer has more than 500 transaction this week
// it checks, if the customer has transaction every day in this week
// if all the requirement is fulfilled, then points is added to customer account


@Controller
public class PointsController {

    @Autowired
    TransactionController transactionController;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private PointsService pointsService;

    @Autowired
    private PointsHistoryService pointsHistoryService;

    // This is view page for collecting points
    @RequestMapping(value = "/collectPoints", method = RequestMethod.POST)
    public String collectPoints(@RequestParam("accountNo") int accountNo, Model model) {
        model.addAttribute("accountNo", accountNo);
        return "customer/collectPoints";
    }

    // This mapping is for viewing the points history of particular customer
    @RequestMapping(value = "/viewPointsHistory", method = RequestMethod.POST)
    public String viewPointHistory(@RequestParam("accountNo") int accountNo, Model model) {
        List<PointsHistory> pointsHistoryList = pointsHistoryService.getPointsHistoryList(customerService.getCustomer(accountNo));
        model.addAttribute("pointsHistoryList", pointsHistoryList);
        model.addAttribute("accountNo", accountNo);
        model.addAttribute("password", customerService.getCustomer(accountNo).getPassword());
        return "customer/viewPointHistory";
    }

    // Viewing available or pending points
    @RequestMapping(value = "/viewPoints", method = RequestMethod.POST)
    public String viewPoints(@RequestParam("accountNo") int accountNo, Model model) {
        Points points = pointsService.getPointOfCustomer(accountNo);
        model.addAttribute("points", points);
        model.addAttribute("accountNo", accountNo);
        model.addAttribute("password", customerService.getCustomer(accountNo).getPassword());
        return "customer/viewPoints";
    }

    // adding point to customer account, if all the requirement is fulfilled
    @RequestMapping(value = "/doCollect", method = RequestMethod.POST)
    public String doCollect(@RequestParam("accountNo") int accountNo,
                            @RequestParam("date") String date,
                            @RequestParam("points") float p,
                            Model model) {

        Date d = Date.valueOf(date);//converting string into sql date
        Points points = pointsService.getPointOfCustomer(accountNo);

        // To check if the transaction is on end of the week
        if (d.getDay() != 0) {
            model.addAttribute("msg", "It is not the end of week. Try on end of week");
            model.addAttribute("accountNo", accountNo);

            return "customer/collectPoints";
        }

        // To Stimulate real life banking system
        // Date cannot be older than last transaction date
        if (points != null) {
             if(transactionController.compareDate(d, points.getLastDateOfTransaction()) < 0){
                model.addAttribute("msg", "Please enter newer date from last transaction!");
                model.addAttribute("accountNo", accountNo);

                return "customer/collectPoints";
            }
        }

        // If given point is not enough than available point, return
        if (p > points.getCurrAvailablePoints()) {
            model.addAttribute("msg", "Excess point than available");
            model.addAttribute("accountNo", accountNo);

            return "customer/collectPoints";
        }

        // Checking if customer have spent 500 in last week
        LocalDate dateBefore7Days = d.toLocalDate().minusDays(7);
        List<Transaction> transactionList = pointsService.getLastSevenDayTransaction(customerService.getCustomer(accountNo), Date.valueOf(dateBefore7Days));
        boolean isSpent500 = calculateSpentOfLastWeek(transactionList);
        boolean isSpentEveryWeek = calculateSpentEverydayOfWeek(transactionList, d);

        if(!isSpent500 && !isSpentEveryWeek) {
            // Displaying that this week transaction is less
            model.addAttribute("msg", "You cannot collect it, Transaction not enough this week");
            model.addAttribute("accountNo", accountNo);

            return "customer/collectPoints";
        }


        // When all requirement are fulfilled, the point added
        // Updating account with new balance
        float amount = p / 100.0f;
        Customer customer = customerService.getCustomer(accountNo);
        customer.setCurrentBalance(customer.getCurrentBalance() + amount);
        customerService.updateCustomer(customer);

        // Added points added to transaction
        Transaction transaction = new Transaction(amount, d, "Points added", customer, customer);
        transactionService.insertTransaction(transaction);

        // Updating points table
        // Adding point of points
        transactionController.calculatePointAndSave(points, amount, d, accountNo);
        points.setUsedPoints(p);
        points.setCurrAvailablePoints(points.getCurrAvailablePoints() - p);
        pointsService.update(points);

        // Displaying success message
        model.addAttribute("msg", "Successfully added");
        model.addAttribute("accountNo", accountNo);

        return "customer/collectPoints";
    }

    // Calculating if the customer has transaction every day of last week
    private boolean calculateSpentEverydayOfWeek(List<Transaction> transactionList, Date d) {
        boolean[] isEveryDay = new boolean[7];
        for(int i = 0; i < 7; i++) {
            Date dd = Date.valueOf(d.toLocalDate().minusDays(i));
            for(Transaction t: transactionList) {
                 if(t.getDate().equals(dd)) {
                     isEveryDay[i] = true;
                     System.out.println(isEveryDay[i]);
                     break;
                 }
             }
        }

        for(int i = 0; i < 7; i++) {

            if(!isEveryDay[i]) return false;
        }
        return true;
    }

    // Calculating if the customer has spent 500 from last week
    private boolean calculateSpentOfLastWeek(List<Transaction> transactionList) {
        float total = 0.0f;
        for(Transaction t: transactionList) {
            total += t.getAmount();
        }
        return total >= 500.0f;
    }
}
