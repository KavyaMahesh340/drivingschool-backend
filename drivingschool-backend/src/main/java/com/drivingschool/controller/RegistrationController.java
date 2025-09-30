package com.drivingschool.controller;

import com.drivingschool.model.Registration;
import com.drivingschool.model.Customer;
import com.drivingschool.service.RegistrationService;
import com.drivingschool.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/registrations")
public class RegistrationController {
    
    @Autowired
    private RegistrationService registrationService;
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping
    public String listRegistrations(Model model) {
        List<Registration> registrations = registrationService.getAllRegistrations();
        Long totalCount = registrationService.getTotalRegistrations();
        model.addAttribute("registrations", registrations);
        model.addAttribute("totalCount", totalCount);
        return "registrations/list";
    }
    
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("registration", new Registration());
        model.addAttribute("customers", customerService.getAllCustomers());
        return "registrations/form";
    }
    
    @PostMapping
    public String saveRegistration(@ModelAttribute Registration registration) {
        registrationService.saveRegistration(registration);
        return "redirect:/registrations";
    }
    
    @GetMapping("/edit/{username}")
    public String showEditForm(@PathVariable String username, Model model) {
        Registration registration = registrationService.getRegistrationById(username).orElse(null);
        if (registration != null) {
            model.addAttribute("registration", registration);
            model.addAttribute("customers", customerService.getAllCustomers());
            return "registrations/form";
        }
        return "redirect:/registrations";
    }
    
    @GetMapping("/delete/{username}")
    public String deleteRegistration(@PathVariable String username) {
        registrationService.deleteRegistration(username);
        return "redirect:/registrations";
    }
    
    @GetMapping("/customer/{customerId}")
    public String getRegistrationsByCustomer(@PathVariable Integer customerId, Model model) {
        List<Registration> registrations = registrationService.getRegistrationsByCustomerId(customerId);
        Customer customer = customerService.getCustomerById(customerId).orElse(null);
        model.addAttribute("registrations", registrations);
        model.addAttribute("customer", customer);
        return "registrations/list";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Registration registration = registrationService.getRegistrationById(username).orElse(null);
        
        if (registration != null && registration.getPassword().equals(password)) {
            model.addAttribute("customer", registration.getCustomer());
            return "dashboard/customer";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}