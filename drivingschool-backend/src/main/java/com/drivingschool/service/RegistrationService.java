package com.drivingschool.service;

import com.drivingschool.model.Registration;
import com.drivingschool.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    
    @Autowired
    private RegistrationRepository registrationRepository;
    
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }
    
    public Optional<Registration> getRegistrationById(String username) {
        return registrationRepository.findById(username);
    }
    
    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }
    
    public void deleteRegistration(String username) {
        registrationRepository.deleteById(username);
    }
    
    public List<Registration> getRegistrationsByCustomerId(Integer customerId) {
        return registrationRepository.findByCustomer_CustomerId(customerId);
    }
    
    public List<Registration> getRegistrationsByVehicle(String vehicle) {
        return registrationRepository.findByVehicleRegistered(vehicle);
    }
    
    public Long getTotalRegistrations() {
        return registrationRepository.countTotalRegistrations();
    }
    
    public Registration authenticateUser(String username, String password) {
        return registrationRepository.findByUsernameAndPassword(username, password);
    }
}