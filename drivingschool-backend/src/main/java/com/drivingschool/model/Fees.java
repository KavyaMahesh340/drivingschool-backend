package com.drivingschool.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fees")
public class Fees {
    @Id
    @Column(name = "id_proof")
    private String idProof;
    
    @Column(name = "staff_id")
    private Integer staffId;
    
    private String course;
    private Integer fees;
    private String discount;
    
    @Column(name = "reciept_no")
    private String receiptNo;
    
    @Column(name = "payment_mode")
    private String paymentMode;
    
    @Column(name = "course_end_date")
    private LocalDate courseEndDate;
    
    @ManyToOne
    @JoinColumn(name = "staff_id", insertable = false, updatable = false)
    private Instructor instructor;
    
    // Constructors
    public Fees() {}
    
    public Fees(String idProof, Integer staffId, String course, Integer fees, 
               String discount, String receiptNo, String paymentMode, LocalDate courseEndDate) {
        this.idProof = idProof;
        this.staffId = staffId;
        this.course = course;
        this.fees = fees;
        this.discount = discount;
        this.receiptNo = receiptNo;
        this.paymentMode = paymentMode;
        this.courseEndDate = courseEndDate;
    }
    
    // Getters and Setters
    public String getIdProof() { return idProof; }
    public void setIdProof(String idProof) { this.idProof = idProof; }
    
    public Integer getStaffId() { return staffId; }
    public void setStaffId(Integer staffId) { this.staffId = staffId; }
    
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    
    public Integer getFees() { return fees; }
    public void setFees(Integer fees) { this.fees = fees; }
    
    public String getDiscount() { return discount; }
    public void setDiscount(String discount) { this.discount = discount; }
    
    public String getReceiptNo() { return receiptNo; }
    public void setReceiptNo(String receiptNo) { this.receiptNo = receiptNo; }
    
    public String getPaymentMode() { return paymentMode; }
    public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }
    
    public LocalDate getCourseEndDate() { return courseEndDate; }
    public void setCourseEndDate(LocalDate courseEndDate) { this.courseEndDate = courseEndDate; }
    
    public Instructor getInstructor() { return instructor; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
}