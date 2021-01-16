package pl.kab.carstogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kab.carstogo.model.Branch;
import pl.kab.carstogo.service.BranchService;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    private final BranchService branchService;
    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping
    public List<Branch> findAll() {
        return branchService.findAll();
    }

    @PostMapping
    public Branch createBranch(@RequestBody Branch branch) {
        return branchService.addBranch(branch);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable("id") Integer id) {
        branchService.remove(id);
    }

}
