package com.drivingschool.controller;

import com.drivingschool.model.Customer;
import com.drivingschool.model.Instructor;
import com.drivingschool.service.CustomerService;
import com.drivingschool.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private InstructorService instructorService;
    
    @GetMapping
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers/list";
    }
    
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("instructors", instructorService.getAllInstructors());
        return "customers/form";
    }
    
    @PostMapping
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Customer customer = customerService.getCustomerById(id).orElse(null);
        if (customer != null) {
            model.addAttribute("customer", customer);
            model.addAttribute("instructors", instructorService.getAllInstructors());
            return "customers/form";
        }
        return "redirect:/customers";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
    
    @GetMapping("/course/{course}")
    public String getCustomersByCourse(@PathVariable String course, Model model) {
        List<Customer> customers = customerService.getCustomersByCourse(course);
        model.addAttribute("customers", customers);
        model.addAttribute("course", course);
        return "customers/list";
    }
}