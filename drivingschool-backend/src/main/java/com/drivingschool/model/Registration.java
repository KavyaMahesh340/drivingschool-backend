package com.drivingschool.model;

import jakarta.persistence.*;

@Entity
@Table(name = "registration")
public class Registration {
    @Id
    private String username;
    
    private String password;
    
    @Column(name = "vechileregistered")
    private String vehicleRegistered;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    // Constructors
    public Registration() {}
    
    public Registration(String username, String password, String vehicleRegistered) {
        this.username = username;
        this.password = password;
        this.vehicleRegistered = vehicleRegistered;
    }
    
    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getVehicleRegistered() { return vehicleRegistered; }
    public void setVehicleRegistered(String vehicleRegistered) { this.vehicleRegistered = vehicleRegistered; }
    
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}