package pl.kab.carstogo.entity;

import pl.kab.carstogo.model.Branch;
import pl.kab.carstogo.model.Car;
import pl.kab.carstogo.model.Employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class BranchEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String city;
    private String address;
    @OneToMany
    private List<Employee> employees;
    @OneToMany
    private List<Car> cars;

    public BranchEntity() {}

    public BranchEntity(String city, String address, List<Employee> employees, List<Car> cars) {
        this.city = city;
        this.address = address;
        this.employees = employees;
        this.cars = cars;
    }

    public Branch mapToBranch() {
        Branch branch = new Branch(city,address,employees,cars);
        branch.setId(id);
        return branch;
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
        BranchEntity that = (BranchEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(city, that.city) && Objects.equals(address, that.address) && Objects.equals(employees, that.employees) && Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, address, employees, cars);
    }
}
