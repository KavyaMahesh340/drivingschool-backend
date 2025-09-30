package com.drivingschool.controller;

import com.drivingschool.model.Test;
import com.drivingschool.model.Customer;
import com.drivingschool.service.TestService;
import com.drivingschool.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/tests")
public class TestController {
    
    @Autowired
    private TestService testService;
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping
    public String listTests(Model model) {
        List<Test> tests = testService.getAllTests();
        model.addAttribute("tests", tests);
        return "tests/list";
    }
    
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("test", new Test());
        model.addAttribute("customers", customerService.getAllCustomers());
        return "tests/form";
    }
    
    @PostMapping
    public String saveTest(@ModelAttribute Test test) {
        testService.saveTest(test);
        return "redirect:/tests";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Test test = testService.getTestById(id).orElse(null);
        if (test != null) {
            model.addAttribute("test", test);
            model.addAttribute("customers", customerService.getAllCustomers());
            return "tests/form";
        }
        return "redirect:/tests";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteTest(@PathVariable String id) {
        testService.deleteTest(id);
        return "redirect:/tests";
    }
    
    @GetMapping("/customer/{customerId}")
    public String getTestsByCustomer(@PathVariable Integer customerId, Model model) {
        List<Test> tests = testService.getTestsByCustomerId(customerId);
        Customer customer = customerService.getCustomerById(customerId).orElse(null);
        model.addAttribute("tests", tests);
        model.addAttribute("customer", customer);
        return "tests/list";
    }
}