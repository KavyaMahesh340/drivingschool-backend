// File: src/main/java/com/drivingschool/service/FeesService.java

package com.drivingschool.service;

import com.drivingschool.model.Fees;
import com.drivingschool.repository.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FeesService {
    
    @Autowired
    private FeesRepository feesRepository;
    
    public List<Fees> getAllFees() {
        return feesRepository.findAll();
    }
    
    public Optional<Fees> getFeesById(String idProof) {
        return feesRepository.findById(idProof);
    }
    
    public Fees saveFees(Fees fees) {
        return feesRepository.save(fees);
    }
    
    public void deleteFees(String idProof) {
        feesRepository.deleteById(idProof);
    }
    
    public Integer getTotalFees() {
        Integer total = feesRepository.getTotalFees();
        return total != null ? total : 0;
    }
    
    public Integer getMinimumFees() {
        Integer min = feesRepository.getMinimumFees();
        return min != null ? min : 0;
    }
    
    public List<Fees> getFeesByStaffId(Integer staffId) {
        return feesRepository.findByStaffId(staffId);
    }
    
    public List<Fees> getFeesByCourse(String course) {
        return feesRepository.findByCourse(course);
    }
    
    public List<Fees> getFeesByPaymentMode(String paymentMode) {
        return feesRepository.findByPaymentMode(paymentMode);
    }
    
    public Integer getTotalRevenueByInstructor(Integer staffId) {
        List<Fees> feesList = feesRepository.findByStaffId(staffId);
        return feesList.stream()
                .mapToInt(Fees::getFees)
                .sum();
    }
    
    public Integer getTotalRevenueByCourse(String course) {
        List<Fees> feesList = feesRepository.findByCourse(course);
        return feesList.stream()
                .mapToInt(Fees::getFees)
                .sum();
    }
    
    public long getFeesCount() {
        return feesRepository.count();
    }
    
    public boolean existsById(String idProof) {
        return feesRepository.existsById(idProof);
    }
}