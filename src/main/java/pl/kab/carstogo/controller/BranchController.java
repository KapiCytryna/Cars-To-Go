package pl.kab.carstogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PatchMapping("/{id}")
    public ResponseEntity patchEmployee(@PathVariable("id") Integer id,
                                   @RequestParam("field") String field,
                                   @RequestParam("value") String value) {
        try {
            return new ResponseEntity(branchService.patchBranch(id, field, value), HttpStatus.ACCEPTED);
        } catch (NumberFormatException e) {
            return new ResponseEntity("Bad format for value/field try again", HttpStatus.BAD_REQUEST);
        }
    }
}
