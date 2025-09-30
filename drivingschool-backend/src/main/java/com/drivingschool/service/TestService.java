package com.drivingschool.service;

import com.drivingschool.model.Test;
import com.drivingschool.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    
    @Autowired
    private TestRepository testRepository;
    
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }
    
    public Optional<Test> getTestById(String numberPlate) {
        return testRepository.findById(numberPlate);
    }
    
    public Test saveTest(Test test) {
        return testRepository.save(test);
    }
    
    public void deleteTest(String numberPlate) {
        testRepository.deleteById(numberPlate);
    }
    
    public List<Test> getTestsByCustomerId(Integer customerId) {
        return testRepository.findByCustomer_CustomerId(customerId);
    }
    
    public List<Test> getTestsByCourse(String course) {
        return testRepository.findByCourseEnrolled(course);
    }
    
    public List<Test> getTestsByRtoRegistered(String rto) {
        return testRepository.findByRtoRegistered(rto);
    }
    
    public Long getTotalTests() {
        return testRepository.countTotalTests();
    }
}