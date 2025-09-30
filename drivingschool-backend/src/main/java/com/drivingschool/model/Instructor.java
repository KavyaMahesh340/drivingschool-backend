package com.drivingschool.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @Column(name = "staff_id")
    private Integer staffId;
    
    @Column(name = "courses_offered")
    private String coursesOffered;
    
    @Column(name = "instructor_name")
    private String instructorName;
    
    private Integer salary;
    private String emailid;
    private String phonenumber;
    private String experience;
    private String address;
    
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Customer> customers;
    
    // Constructors
    public Instructor() {}
    
    public Instructor(Integer staffId, String coursesOffered, String instructorName, 
                     Integer salary, String emailid, String phonenumber, 
                     String experience, String address) {
        this.staffId = staffId;
        this.coursesOffered = coursesOffered;
        this.instructorName = instructorName;
        this.salary = salary;
        this.emailid = emailid;
        this.phonenumber = phonenumber;
        this.experience = experience;
        this.address = address;
    }
    
    // Getters and Setters
    public Integer getStaffId() { return staffId; }
    public void setStaffId(Integer staffId) { this.staffId = staffId; }
    
    public String getCoursesOffered() { return coursesOffered; }
    public void setCoursesOffered(String coursesOffered) { this.coursesOffered = coursesOffered; }
    
    public String getInstructorName() { return instructorName; }
    public void setInstructorName(String instructorName) { this.instructorName = instructorName; }
    
    public Integer getSalary() { return salary; }
    public void setSalary(Integer salary) { this.salary = salary; }
    
    public String getEmailid() { return emailid; }
    public void setEmailid(String emailid) { this.emailid = emailid; }
    
    public String getPhonenumber() { return phonenumber; }
    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }
    
    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public List<Customer> getCustomers() { return customers; }
    public void setCustomers(List<Customer> customers) { this.customers = customers; }
}