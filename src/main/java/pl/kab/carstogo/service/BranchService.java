package pl.kab.carstogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kab.carstogo.entity.BranchEntity;
import pl.kab.carstogo.model.Branch;
import pl.kab.carstogo.repository.BranchRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BranchService {
    private final BranchRepository branchRepository;

    @Autowired
    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public List<Branch> findAll(){
        return branchRepository.findAll().stream()
                .map(BranchEntity::mapToBranch)
                .collect(Collectors.toList());
    }

    public Branch addBranch(Branch branch){
        BranchEntity branchEntity = branchRepository.save(branch.mapToBranchEntity());
        return branchEntity.mapToBranch();
    }

    public Branch findByID(Integer id) {
        return branchRepository.findById(id).orElseThrow().mapToBranch();
    }

    public void remove(Integer id) {

    }
}
