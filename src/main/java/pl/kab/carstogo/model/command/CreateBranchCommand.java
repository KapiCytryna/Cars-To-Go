package pl.kab.carstogo.model.command;

import java.util.List;

public class CreateBranchCommand {
    private Integer id;
    private String city;
    private String address;
    private List<Integer> employeesIds;
    private List<Integer> carIds;

    public CreateBranchCommand() {}

    public CreateBranchCommand(String city, String address, List<Integer> employeesIds, List<Integer> carIds) {
        this.city = city;
        this.address = address;
        this.employeesIds = employeesIds;
        this.carIds = carIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Integer> getEmployeesIds() {
        return employeesIds;
    }

    public void setEmployeesIds(List<Integer> employeesIds) {
        this.employeesIds = employeesIds;
    }

    public List<Integer> getCarIds() {
        return carIds;
    }

    public void setCarIds(List<Integer> carIds) {
        this.carIds = carIds;
    }
}
