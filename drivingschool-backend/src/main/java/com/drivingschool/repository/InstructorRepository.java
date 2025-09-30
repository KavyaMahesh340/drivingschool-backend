package com.drivingschool.repository;

import com.drivingschool.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    List<Instructor> findBySalaryGreaterThan(Integer salary);
    
    @Query("SELECT i FROM Instructor i WHERE i.salary BETWEEN ?1 AND ?2")
    List<Instructor> findBySalaryBetween(Integer minSalary, Integer maxSalary);
    
    @Query("SELECT AVG(i.salary) FROM Instructor i")
    Double getAverageSalary();
}