package com.drivingschool.service;

import com.drivingschool.model.Instructor;
import com.drivingschool.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    
    @Autowired
    private InstructorRepository instructorRepository;
    
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }
    
    public Optional<Instructor> getInstructorById(Integer id) {
        return instructorRepository.findById(id);
    }
    
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }
    
    public void deleteInstructor(Integer id) {
        instructorRepository.deleteById(id);
    }
    
    public List<Instructor> getInstructorsWithSalaryGreaterThan(Integer salary) {
        return instructorRepository.findBySalaryGreaterThan(salary);
    }
    
    public Double getAverageSalary() {
        return instructorRepository.getAverageSalary();
    }
}