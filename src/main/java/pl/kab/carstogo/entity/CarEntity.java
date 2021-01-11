package pl.kab.carstogo.entity;

import pl.kab.carstogo.model.Car;
import pl.kab.carstogo.model.enums.BodyType;
import pl.kab.carstogo.model.enums.Brand;
import pl.kab.carstogo.model.enums.Status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class CarEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private Brand brand;

    private String model;

    private BodyType body;

    private Integer productionYear;

    private String color;

    private Integer mileage;

    private Status status;

    private Double rent;

    public CarEntity() {}

    public CarEntity(Brand brand, String model, BodyType body, Integer productionYear, String color, Integer mileage, Status status, Double rent) {
        this.brand = brand;
        this.model = model;
        this.body = body;
        this.productionYear = productionYear;
        this.color = color;
        this.mileage = mileage;
        this.status = status;
        this.rent = rent;
    }

    public Car mapToCar(){
        Car car = new Car(brand,model,body,productionYear,color,mileage,status,rent);
        car.setId(id);
        return car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BodyType getBody() {
        return body;
    }

    public void setBody(BodyType body) {
        this.body = body;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return Objects.equals(id, carEntity.id) && brand == carEntity.brand && Objects.equals(model, carEntity.model) && body == carEntity.body && Objects.equals(productionYear, carEntity.productionYear) && Objects.equals(color, carEntity.color) && Objects.equals(mileage, carEntity.mileage) && status == carEntity.status && Objects.equals(rent, carEntity.rent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, body, productionYear, color, mileage, status, rent);
    }
}
