package com.springMVC.Controller;


import com.springMVC.DAO.CustomerDAO;
import com.springMVC.Entity.Customer;
import com.springMVC.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomer(Model model) {

        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "List-customer";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Customer theCustomer =new Customer();
        model.addAttribute("customer",theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        customerService.saveCustomer(customer);
        return "redirect:/customer/list";

    }


}
