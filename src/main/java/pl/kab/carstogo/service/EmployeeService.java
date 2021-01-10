package pl.kab.carstogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pl.kab.carstogo.entity.BranchEntity;
import pl.kab.carstogo.entity.EmployeeEntity;
import pl.kab.carstogo.model.Employee;
import pl.kab.carstogo.repository.BranchRepository;
import pl.kab.carstogo.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Lazy
    private final CarService carService;
    @Lazy
    private final BranchService branchService;
    @Lazy
    private final BranchRepository branchRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, CarService carService, BranchService branchService, BranchRepository branchRepository) {
        this.employeeRepository = employeeRepository;
        this.carService = carService;
        this.branchService = branchService;
        this.branchRepository = branchRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll().stream()
                .map(EmployeeEntity::mapToEmployee)
                .collect(Collectors.toList());
    }

    public Employee addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository
                .save(employee.mapToEmployeeEntity());

        BranchEntity branchEntity = branchRepository.findById(employeeEntity.getBranch().getId()).orElseThrow();
        branchEntity.getEmployees().add(employeeEntity);
        branchRepository.save(branchEntity);

        return employeeEntity.mapToEmployee();
    }

    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElseThrow().mapToEmployee();
    }

    public EmployeeEntity findEntityById(Integer id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    public Employee updateEmployee(Integer id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow();
        Optional.ofNullable(employee.getFirstName()).ifPresent(employeeEntity::setFirstName);
        Optional.ofNullable(employee.getLastName()).ifPresent(employeeEntity::setLastName);
        Optional.ofNullable(employee.getPosition()).ifPresent(employeeEntity::setPosition);
        Optional.ofNullable(employee.getBranch()).ifPresent(e ->employeeEntity
                .setBranch(e.mapToBranchEntity()));
        employeeRepository.save(employeeEntity);
        return employeeEntity.mapToEmployee();
    }

    public void remove(Integer id) {
        employeeRepository.deleteById(id);
    }
}
