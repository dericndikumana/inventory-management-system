package com.ims.controller;

import com.ims.model.Asset;
import com.ims.service.AssetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @GetMapping
    public String list(Model model,
                       @RequestParam(required = false) String search,
                       @RequestParam(required = false) String type,
                       @RequestParam(required = false) String status) {
        if (search != null && !search.isEmpty()) {
            model.addAttribute("assets", assetService.search(search));
            model.addAttribute("search", search);
        } else if (type != null && !type.isEmpty()) {
            model.addAttribute("assets", assetService.findByDeviceType(type));
        } else if (status != null && !status.isEmpty()) {
            model.addAttribute("assets", assetService.findByStatus(status));
        } else {
            model.addAttribute("assets", assetService.findAll());
        }
        return "assets/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("asset", new Asset());
        return "assets/add";
    }

    @PostMapping("/add")
    public String addAsset(@Valid @ModelAttribute Asset asset,
                           BindingResult result,
                           RedirectAttributes ra) {
        if (result.hasErrors()) return "assets/add";
        assetService.save(asset);
        ra.addFlashAttribute("success", "✅ Asset registered successfully!");
        return "redirect:/assets";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Asset asset = assetService.findById(id)
            .orElseThrow(() -> new RuntimeException("Asset not found"));
        model.addAttribute("asset", asset);
        return "assets/edit";
    }

    @PostMapping("/edit/{id}")
    public String editAsset(@PathVariable Long id,
                            @Valid @ModelAttribute Asset asset,
                            BindingResult result,
                            RedirectAttributes ra) {
        if (result.hasErrors()) return "assets/edit";
        asset.setId(id);
        assetService.save(asset);
        ra.addFlashAttribute("success", "✏️ Asset updated successfully!");
        return "redirect:/assets";
    }

    @GetMapping("/delete/{id}")
    public String deleteAsset(@PathVariable Long id, RedirectAttributes ra) {
        assetService.deleteById(id);
        ra.addFlashAttribute("success", "🗑️ Asset deleted successfully!");
        return "redirect:/assets";
    }
}