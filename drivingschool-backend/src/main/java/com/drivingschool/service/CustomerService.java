package com.drivingschool.service;

import com.drivingschool.model.Customer;
import com.drivingschool.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }
    
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
    
    public List<Customer> getCustomersByCourse(String course) {
        return customerRepository.findByCoursejoined(course);
    }
    
    public List<Customer> getCustomersStartingWith(String prefix) {
        return customerRepository.findByCustomerNameStartingWith(prefix);
    }
}