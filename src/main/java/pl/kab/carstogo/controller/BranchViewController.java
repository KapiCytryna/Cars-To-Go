package pl.kab.carstogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kab.carstogo.model.Branch;
import pl.kab.carstogo.model.Car;
import pl.kab.carstogo.service.BranchService;

@Controller
@RequestMapping("/branch")
public class BranchViewController {

    private final BranchService branchService;

    public BranchViewController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/all")
    public String allBranches(final Model model) {
        model.addAttribute("Brances", branchService.findAll());
        return "branch/list";
    }

    @GetMapping("/add")
    public String addBranch (final Model model) {
        model.addAttribute("branchForm", new Branch());
        return "branch/form";
    }

    @PostMapping("/add")
    public String addBranchFromProcess(@ModelAttribute("BranchForm") Branch branch) {
        branchService.addBranch(branch);
        return "redirect:/branch/all";
    }

    @GetMapping("/edit/{id}")
    public String editBranchForm(@PathVariable("id") Integer id, Model model){
        model.addAttribute("branchForm", branchService.findByID(id));
        return "branch/edit-form";
    }

    @PostMapping("/edit/{id}")
    public String editBranchFormProcess(@ModelAttribute Branch branch, @PathVariable("id") Integer id) {
        branchService.update(id, branch);
        return "redirect:/branch/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteBranchProcess(@PathVariable("id") Integer id){
        branchService.remove(id);
        return "redirect:/branch/all";
    }
}