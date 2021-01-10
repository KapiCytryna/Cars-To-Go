package pl.kab.carstogo.entity;

import pl.kab.carstogo.model.Branch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
public class BranchEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String city;
    private String address;
    @OneToMany(mappedBy = "branch")
    private List<EmployeeEntity> employees;
    @OneToMany
    private List<CarEntity> cars;

    public BranchEntity() {}

    public BranchEntity(String city, String address) {
        this.city = city;
        this.address = address;
    }

    public Branch mapToBranch() {
        Branch branch = new Branch(city,address,
                employees.stream().map(EmployeeEntity::mapToEmployee).collect(Collectors.toList()),
                cars.stream().map(CarEntity::mapToCar).collect(Collectors.toList()));
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

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }

    public List<CarEntity> getCars() {
        return cars;
    }

    public void setCars(List<CarEntity> cars) {
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
