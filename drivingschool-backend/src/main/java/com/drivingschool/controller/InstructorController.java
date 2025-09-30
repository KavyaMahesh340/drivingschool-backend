package com.drivingschool.controller;

import com.drivingschool.model.Instructor;
import com.drivingschool.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/instructors")
public class InstructorController {
    
    @Autowired
    private InstructorService instructorService;
    
    @GetMapping
    public String listInstructors(Model model) {
        List<Instructor> instructors = instructorService.getAllInstructors();
        Double avgSalary = instructorService.getAverageSalary();
        model.addAttribute("instructors", instructors);
        model.addAttribute("averageSalary", avgSalary);
        return "instructors/list";
    }
    
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructors/form";
    }
    
    @PostMapping
    public String saveInstructor(@ModelAttribute Instructor instructor) {
        instructorService.saveInstructor(instructor);
        return "redirect:/instructors";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Instructor instructor = instructorService.getInstructorById(id).orElse(null);
        if (instructor != null) {
            model.addAttribute("instructor", instructor);
            return "instructors/form";
        }
        return "redirect:/instructors";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteInstructor(@PathVariable Integer id) {
        instructorService.deleteInstructor(id);
        return "redirect:/instructors";
    }
    
    @GetMapping("/high-salary")
    public String getHighSalaryInstructors(Model model) {
        List<Instructor> instructors = instructorService.getInstructorsWithSalaryGreaterThan(40000);
        model.addAttribute("instructors", instructors);
        return "instructors/list";
    }
}