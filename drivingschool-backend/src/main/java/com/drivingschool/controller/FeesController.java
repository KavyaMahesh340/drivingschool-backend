package com.drivingschool.controller;

import com.drivingschool.model.Fees;
import com.drivingschool.service.FeesService;
import com.drivingschool.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/fees")
public class FeesController {
    
    @Autowired
    private FeesService feesService;
    
    @Autowired
    private InstructorService instructorService;
    
    @GetMapping
    public String listFees(Model model) {
        List<Fees> feesList = feesService.getAllFees();
        Integer totalRevenue = feesService.getTotalFees();
        Integer minFee = feesService.getMinimumFees();
        
        model.addAttribute("feesList", feesList);
        model.addAttribute("totalRevenue", totalRevenue);
        model.addAttribute("minFee", minFee);
        return "fees/list";
    }
    
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("fees", new Fees());
        model.addAttribute("instructors", instructorService.getAllInstructors());
        return "fees/form";
    }
    
    @PostMapping
    public String saveFees(@ModelAttribute Fees fees) {
        feesService.saveFees(fees);
        return "redirect:/fees";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Fees fees = feesService.getFeesById(id).orElse(null);
        if (fees != null) {
            model.addAttribute("fees", fees);
            model.addAttribute("instructors", instructorService.getAllInstructors());
            return "fees/form";
        }
        return "redirect:/fees";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteFees(@PathVariable String id) {
        feesService.deleteFees(id);
        return "redirect:/fees";
    }
    
    @GetMapping("/course/{course}")
    public String getFeesByCourse(@PathVariable String course, Model model) {
        List<Fees> feesList = feesService.getFeesByCourse(course);
        Integer courseRevenue = feesService.getTotalRevenueByCourse(course);
        
        model.addAttribute("feesList", feesList);
        model.addAttribute("course", course);
        model.addAttribute("courseRevenue", courseRevenue);
        return "fees/list";
    }
}