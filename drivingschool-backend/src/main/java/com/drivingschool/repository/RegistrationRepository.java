package com.drivingschool.repository;

import com.drivingschool.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, String> {
    List<Registration> findByCustomer_CustomerId(Integer customerId);
    
    List<Registration> findByVehicleRegistered(String vehicle);
    
    @Query("SELECT COUNT(r) FROM Registration r")
    Long countTotalRegistrations();
    
    @Query("SELECT r FROM Registration r WHERE r.username = ?1 AND r.password = ?2")
    Registration findByUsernameAndPassword(String username, String password);
}