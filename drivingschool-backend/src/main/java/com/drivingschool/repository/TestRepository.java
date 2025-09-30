package com.drivingschool.repository;

import com.drivingschool.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, String> {
    List<Test> findByCustomer_CustomerId(Integer customerId);
    
    List<Test> findByCourseEnrolled(String course);
    
    @Query("SELECT t FROM Test t WHERE t.rtoRegistered = ?1")
    List<Test> findByRtoRegistered(String rtoRegistered);
    
    @Query("SELECT COUNT(t) FROM Test t")
    Long countTotalTests();
}