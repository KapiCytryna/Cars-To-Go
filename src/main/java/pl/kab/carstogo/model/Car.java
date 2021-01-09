package pl.kab.carstogo.model;

import pl.kab.carstogo.entity.CarEntity;

public class Car {

    private Integer id;

    private Brand brand;

    private String model;

    private BodyType body;

    private Integer productionYear;

    private String color;

    private Integer mileage;

    private Status status;

    private Double rent;

    public Car() {}

    public Car(Brand brand, String model, BodyType body, Integer productionYear, String color, Integer mileage, Status status, Double rent) {
        this.brand = brand;
        this.model = model;
        this.body = body;
        this.productionYear = productionYear;
        this.color = color;
        this.mileage = mileage;
        this.status = status;
        this.rent = rent;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(pl.kab.carstogo.model.Brand brand) {
        this.brand = brand;
    }

    public CarEntity mapToCarEntity(){
        return new CarEntity(getBrand(),getModel(),getBody(),getProductionYear(),getColor(),getMileage(),getStatus(),getRent());
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}