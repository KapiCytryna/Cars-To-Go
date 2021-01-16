package pl.kab.carstogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pl.kab.carstogo.entity.BranchEntity;
import pl.kab.carstogo.entity.EmployeeEntity;
import pl.kab.carstogo.model.Employee;
import pl.kab.carstogo.model.command.CreateEmployeeCommand;
import pl.kab.carstogo.model.enums.Position;
import pl.kab.carstogo.repository.BranchRepository;
import pl.kab.carstogo.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Lazy
    private final BranchService branchService;
    @Lazy
    private final BranchRepository branchRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, BranchService branchService, BranchRepository branchRepository) {
        this.employeeRepository = employeeRepository;
        this.branchService = branchService;
        this.branchRepository = branchRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll().stream()
                .map(EmployeeEntity::mapToEmployee)
                .collect(Collectors.toList());
    }

    public void saveEmployee(String firstName, String lastName, Position position, Integer branchId){
        EmployeeEntity employee = new EmployeeEntity();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPosition(position);

        BranchEntity branch = branchRepository.findById(branchId).orElseThrow();
        employee.setBranch(branch);

        employeeRepository.save(employee);
    }

    public Employee addEmployee(CreateEmployeeCommand command) {
        EmployeeEntity employeeEntity = new EmployeeEntity(command.getFirstName(), command.getLastName(), command.getPosition());
        employeeEntity.setBranch(branchService.findEntityByID(command.getBranchId()));
        employeeRepository.save(employeeEntity);
        return employeeEntity.mapToEmployee();
    }

    public Employee findById(Integer id) {
        return findEntityById(id).mapToEmployee();
    }

    public EmployeeEntity findEntityById(Integer id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    public Employee updateEmployee(Integer id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow();
        Optional.ofNullable(employee.getFirstName()).ifPresent(employeeEntity::setFirstName);
        Optional.ofNullable(employee.getLastName()).ifPresent(employeeEntity::setLastName);
        Optional.ofNullable(employee.getPosition()).ifPresent(employeeEntity::setPosition);
        employeeRepository.save(employeeEntity);
        return employeeEntity.mapToEmployee();
    }

    public void remove(Integer id) {
        employeeRepository.deleteById(id);
    }
}
