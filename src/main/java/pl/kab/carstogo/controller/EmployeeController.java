package pl.kab.carstogo.controller;

import org.springframework.web.bind.annotation.*;
import pl.kab.carstogo.model.Employee;
import pl.kab.carstogo.model.command.CreateEmployeeCommand;
import pl.kab.carstogo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/Employees")
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") final Integer id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public Employee createOwner(@RequestBody final CreateEmployeeCommand employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") final Integer id) {
        employeeService.remove(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") final Integer id,
                                   @RequestBody final CreateEmployeeCommand employee){
        return employeeService.updateEmployee(id, employee);

    }


}
