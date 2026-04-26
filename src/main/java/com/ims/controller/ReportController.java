package com.ims.controller;

import com.ims.service.AssetService;
import com.ims.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired private AssetService assetService;
    @Autowired private AssignmentService assignmentService;

    @GetMapping
    public String reports(Model model) {
        model.addAttribute("allAssets", assetService.findAll());
        model.addAttribute("allAssignments", assignmentService.findAll());
        model.addAttribute("totalAssets", assetService.countAll());
        model.addAttribute("availableAssets", assetService.countByStatus("AVAILABLE"));
        model.addAttribute("assignedAssets", assetService.countByStatus("ASSIGNED"));
        model.addAttribute("underRepair", assetService.countByStatus("UNDER_REPAIR"));
        model.addAttribute("totalLaptops", assetService.countByType("LAPTOP"));
        model.addAttribute("totalDesktops", assetService.countByType("DESKTOP"));
        model.addAttribute("totalMobiles", assetService.countByType("MOBILE"));
        return "reports/index";
    }
}