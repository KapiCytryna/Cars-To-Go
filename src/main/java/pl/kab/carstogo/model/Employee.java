package pl.kab.carstogo.model;

import pl.kab.carstogo.entity.EmployeeEntity;
import pl.kab.carstogo.model.enums.Position;

import java.util.Objects;

public class Employee extends Person {

    private Position position;

    public Employee(String firstName, String lastName, Position position) {
        super(firstName, lastName);
        this.position = position;
    }
    
    public Employee() {
        super();
    }

    public EmployeeEntity mapToEmployeeEntity() {
        return new EmployeeEntity(getFirstName(), getLastName(), position);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return  true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return
                Objects.equals(position, employee.position) &&
                Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getLastName(), employee.getLastName());
    }
}
