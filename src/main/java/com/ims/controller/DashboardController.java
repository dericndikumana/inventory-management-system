package com.ims.controller;

import com.ims.service.AssetService;
import com.ims.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired 
    private AssetService assetService;
    
    @Autowired 
    private AssignmentService assignmentService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalAssets", assetService.countAll());
        model.addAttribute("availableAssets", assetService.countByStatus("AVAILABLE"));
        model.addAttribute("assignedAssets", assetService.countByStatus("ASSIGNED"));
        model.addAttribute("underRepair", assetService.countByStatus("UNDER_REPAIR"));
        model.addAttribute("activeAssignments", assignmentService.countActive());
        model.addAttribute("totalLaptops", assetService.countByType("LAPTOP"));
        model.addAttribute("totalDesktops", assetService.countByType("DESKTOP"));
        model.addAttribute("totalMobiles", assetService.countByType("MOBILE"));
        model.addAttribute("recentAssignments", assignmentService.findActive());
        return "dashboard";
    }
}