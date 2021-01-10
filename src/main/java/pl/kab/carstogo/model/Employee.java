package pl.kab.carstogo.model;

import pl.kab.carstogo.entity.EmployeeEntity;

import java.util.Objects;

public class Employee extends Person {

    private String position;
    private String branch;

    public Employee(String firstName, String lastName, String position, String branch) {
        super(firstName, lastName);
        this.position = position;
        this.branch = branch;
    }
    
    public Employee() {
        super();
    }

    public EmployeeEntity mapToEmployeeEntity() {
        return new EmployeeEntity(getFirstName(), getLastName(), position, branch);
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
        if (this == obj) return  true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(branch, employee.branch) &&
                Objects.equals(position, employee.position) &&
                Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getLastName(), employee.getLastName());
    }
}
