// File: src/main/java/com/drivingschool/repository/FeesRepository.java

package com.drivingschool.repository;

import com.drivingschool.model.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FeesRepository extends JpaRepository<Fees, String> {
    
    // Find by staff ID
    List<Fees> findByStaffId(Integer staffId);
    
    // Find by course
    List<Fees> findByCourse(String course);
    
    // Find by payment mode
    List<Fees> findByPaymentMode(String paymentMode);
    
    // Get total fees (sum of all fees)
    @Query("SELECT SUM(f.fees) FROM Fees f")
    Integer getTotalFees();
    
    // Get minimum fees
    @Query("SELECT MIN(f.fees) FROM Fees f")
    Integer getMinimumFees();
}