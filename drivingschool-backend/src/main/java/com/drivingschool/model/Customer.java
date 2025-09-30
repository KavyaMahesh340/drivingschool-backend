package com.drivingschool.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private Integer customerId;
    
    private String gender;
    
    @Column(name = "customer_name")
    private String customerName;
    
    @Column(name = "dateofjoin")
    private LocalDate dateOfJoin;
    
    private String emailid;
    private String coursejoined;
    private String address;
    
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    
    // Constructors
    public Customer() {}
    
    public Customer(Integer customerId, String gender, String customerName, 
                   LocalDate dateOfJoin, String emailid, String coursejoined, String address) {
        this.customerId = customerId;
        this.gender = gender;
        this.customerName = customerName;
        this.dateOfJoin = dateOfJoin;
        this.emailid = emailid;
        this.coursejoined = coursejoined;
        this.address = address;
    }
    
    // Getters and Setters
    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    
    public LocalDate getDateOfJoin() { return dateOfJoin; }
    public void setDateOfJoin(LocalDate dateOfJoin) { this.dateOfJoin = dateOfJoin; }
    
    public String getEmailid() { return emailid; }
    public void setEmailid(String emailid) { this.emailid = emailid; }
    
    public String getCoursejoined() { return coursejoined; }
    public void setCoursejoined(String coursejoined) { this.coursejoined = coursejoined; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public Instructor getInstructor() { return instructor; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
}