package pl.kab.carstogo.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kab.carstogo.model.Employee;
import pl.kab.carstogo.model.command.CreateEmployeeCommand;
import pl.kab.carstogo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeViewController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeViewController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public String allEmployees(final Model model){
        model.addAttribute("employeeList", employeeService.findAll());
        return "employee/list";
    }

    @GetMapping("/add")
    public String addEmployee(final Model model){
        model.addAttribute("employeeForm", new CreateEmployeeCommand());
        return "employee/form";
    }

    @PostMapping("/add")
    public String addEmployeeFormProcess(@ModelAttribute("employeeForm") CreateEmployeeCommand employee) {
        //employeeService.addEmployee(employee);
        employeeService.saveEmployee(employee.getFirstName(),employee.getLastName(),employee.getPosition(),employee.getBranchId());
        return "redirect:/employee/all";
    }

    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("employeeForm", employeeService.findById(id));
        return "employee/edit-form";
    }

    @PostMapping("/edit/{id}")
    public String editEmployeeFormProcess(@ModelAttribute Employee employee, @PathVariable("id") Integer id) {
        employeeService.updateEmployee(id, employee);
        return "redirect:/employee/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployeeProcess(@PathVariable("id") Integer id) {
        employeeService.remove(id);
        return "redirect:/employee/all";
    }
}
