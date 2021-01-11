package pl.kab.carstogo.model.command;

import pl.kab.carstogo.model.enums.Position;

public class CreateEmployeeCommand {
    private Integer id;
    private String firstName;
    private String lastName;
    private Position position;
    private Integer branchId;

    public CreateEmployeeCommand() {}

    public CreateEmployeeCommand(String firstName, String lastName, Position position, Integer branchId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.branchId = branchId;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }
}
