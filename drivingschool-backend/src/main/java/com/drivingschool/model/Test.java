package com.drivingschool.model;

import jakarta.persistence.*;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @Column(name = "number_plate")
    private String numberPlate;
    
    @Column(name = "scheduledtime")
    private String scheduledTime;
    
    @Column(name = "rto_registered")
    private String rtoRegistered;
    
    @Column(name = "course_enrolled")
    private String courseEnrolled;
    
    @Column(name = "vechile_provided")
    private String vehicleProvided;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    // Constructors
    public Test() {}
    
    public Test(String numberPlate, String scheduledTime, String rtoRegistered, 
               String courseEnrolled, String vehicleProvided) {
        this.numberPlate = numberPlate;
        this.scheduledTime = scheduledTime;
        this.rtoRegistered = rtoRegistered;
        this.courseEnrolled = courseEnrolled;
        this.vehicleProvided = vehicleProvided;
    }
    
    // Getters and Setters
    public String getNumberPlate() { return numberPlate; }
    public void setNumberPlate(String numberPlate) { this.numberPlate = numberPlate; }
    
    public String getScheduledTime() { return scheduledTime; }
    public void setScheduledTime(String scheduledTime) { this.scheduledTime = scheduledTime; }
    
    public String getRtoRegistered() { return rtoRegistered; }
    public void setRtoRegistered(String rtoRegistered) { this.rtoRegistered = rtoRegistered; }
    
    public String getCourseEnrolled() { return courseEnrolled; }
    public void setCourseEnrolled(String courseEnrolled) { this.courseEnrolled = courseEnrolled; }
    
    public String getVehicleProvided() { return vehicleProvided; }
    public void setVehicleProvided(String vehicleProvided) { this.vehicleProvided = vehicleProvided; }
    
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}