package pl.kab.carstogo.model;

import pl.kab.carstogo.entity.BranchEntity;

import java.util.List;
import java.util.Objects;

public class Branch {

    private Integer id;
    private String city;
    private String address;
    private List<Employee> employees;
    private List<Car> cars;

    public Branch(String city, String address, List<Employee> employees, List<Car> cars) {
        this.city = city;
        this.address = address;
        this.employees = employees;
        this.cars = cars;
    }

    public Branch() {}

    public BranchEntity mapToBranchEntity() {
        return new BranchEntity(city,address);
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(id, branch.id) && Objects.equals(city, branch.city) && Objects.equals(address, branch.address) && Objects.equals(employees, branch.employees) && Objects.equals(cars, branch.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, address, employees, cars);
    }
}
