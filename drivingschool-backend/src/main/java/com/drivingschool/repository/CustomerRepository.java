package com.drivingschool.repository;

import com.drivingschool.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCoursejoined(String course);
    
    List<Customer> findByCustomerNameStartingWith(String prefix);
    
    @Query("SELECT c FROM Customer c WHERE c.coursejoined IN ('Car', 'Scooty')")
    List<Customer> findByCarOrScootyCourse();
    
    @Query("SELECT c.coursejoined, COUNT(c) FROM Customer c GROUP BY c.coursejoined")
    List<Object[]> countCustomersByCourse();
}