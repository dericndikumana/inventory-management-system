package com.ims.controller;

import com.ims.model.Assignment;
import com.ims.service.AssetService;
import com.ims.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired private AssignmentService assignmentService;
    @Autowired private AssetService assetService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("assignments", assignmentService.findAll());
        return "assignments/list";
    }

    @GetMapping("/issue")
    public String issueForm(Model model) {
        model.addAttribute("assignment", new Assignment());
        model.addAttribute("availableAssets", assetService.findAvailable());
        return "assignments/issue";
    }

    @PostMapping("/issue")
    public String issueAsset(@ModelAttribute Assignment assignment,
                             @RequestParam("assetId") Long assetId,
                             Authentication auth,
                             RedirectAttributes ra) {
        assignmentService.issueAsset(assetId, assignment);
        ra.addFlashAttribute("success", "📤 Asset issued successfully!");
        return "redirect:/assignments";
    }

    @GetMapping("/return/{id}")
    public String returnForm(@PathVariable Long id, Model model) {
        Assignment assignment = assignmentService.findById(id)
            .orElseThrow(() -> new RuntimeException("Assignment not found"));
        model.addAttribute("assignment", assignment);
        return "assignments/return";
    }

    @PostMapping("/return/{id}")
    public String returnAsset(@PathVariable Long id,
                              @RequestParam String conditionAtReturn,
                              @RequestParam(required = false) String returnNotes,
                              RedirectAttributes ra) {
        assignmentService.returnAsset(id, conditionAtReturn, returnNotes);
        ra.addFlashAttribute("success", "📥 Asset returned successfully!");
        return "redirect:/assignments";
    }
}