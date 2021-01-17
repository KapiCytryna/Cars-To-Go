package pl.kab.carstogo.model;

import java.time.LocalDate;
import java.util.Objects;

public class Reservation {
    private Integer id;
    private LocalDate date;
    private Client client;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private Branch rentalBranch;
    private Branch returnBranch;
    private Double total;

    public Reservation() {
    }

    public Reservation(LocalDate date, Client client, Car car, LocalDate startDate, LocalDate endDate, Branch rentalBranch, Branch returnBranch, Double total) {
        this.date = date;
        this.client = client;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentalBranch = rentalBranch;
        this.returnBranch = returnBranch;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Branch getRentalBranch() {
        return rentalBranch;
    }

    public void setRentalBranch(Branch rentalBranch) {
        this.rentalBranch = rentalBranch;
    }

    public Branch getReturnBranch() {
        return returnBranch;
    }

    public void setReturnBranch(Branch returnBranch) {
        this.returnBranch = returnBranch;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(client, that.client) && Objects.equals(car, that.car) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(rentalBranch, that.rentalBranch) && Objects.equals(returnBranch, that.returnBranch) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, client, car, startDate, endDate, rentalBranch, returnBranch, total);
    }
}
