package pl.kab.carstogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kab.carstogo.entity.BranchEntity;
import pl.kab.carstogo.model.Branch;
import pl.kab.carstogo.model.Car;
import pl.kab.carstogo.model.Employee;
import pl.kab.carstogo.repository.BranchRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
        branchRepository.deleteById(id);
    }

    public Branch update(Integer id, Branch branch){
        BranchEntity branchEntity = branchRepository.findById(id).orElseThrow();
        Optional.ofNullable(branch.getAddress()).ifPresent(branchEntity::setAddress);
        Optional.ofNullable(branch.getCars()).ifPresent(e -> branchEntity.setCars(
                e.stream()
                    .map(Car::mapToCarEntity)
                    .collect(Collectors.toList())
                )
        );
        Optional.ofNullable(branch.getCity()).ifPresent(branchEntity::setCity);
        Optional.ofNullable(branch.getEmployees()).ifPresent(e -> branchEntity.setEmployees(
                e.stream()
                    .map(Employee::mapToEmployeeEntity)
                    .collect(Collectors.toList())
                )
        );
        branchRepository.save(branchEntity);
        return branchEntity.mapToBranch();
    }
  
    public Branch patchBranch(Integer id, String field, String value) {
        BranchEntity foundBranch = branchRepository.findById(id).orElseThrow();
        if(field.equalsIgnoreCase("city")){
            foundBranch.setCity(value);
        } else if (field.equalsIgnoreCase("address")) {
            foundBranch.setAddress(value);
        }
        branchRepository.save(foundBranch);
        return foundBranch.mapToBranch();
    }
}
