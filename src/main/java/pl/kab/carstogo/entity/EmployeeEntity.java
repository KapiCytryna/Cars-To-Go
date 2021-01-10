package pl.kab.carstogo.entity;

import pl.kab.carstogo.model.Employee;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

public class EmployeeEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String position;
    private String branch;

    public EmployeeEntity() {

    }

    public EmployeeEntity(String firstName, String lastName, String position, String branch) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.branch = branch;
    }

    public Employee mapToEmployee() {
        Employee employee = new Employee(firstName, lastName, position, branch);
        employee.setId(id);
        return employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EmployeeEntity employeeEntity = (EmployeeEntity) obj;
        return Objects.equals(id, employeeEntity.id) &&
                Objects.equals(firstName, employeeEntity.firstName) &&
                Objects.equals(lastName, employeeEntity.lastName) &&
                Objects.equals(branch, employeeEntity.branch) &&
                Objects.equals(position, employeeEntity.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, branch, position);
    }
}