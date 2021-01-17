package pl.kab.carstogo.entity;

import pl.kab.carstogo.model.Branch;
import pl.kab.carstogo.model.Car;
import pl.kab.carstogo.model.Client;
import pl.kab.carstogo.model.Reservation;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class ReservationEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDate date;
    @OneToOne
    private ClientEntity client;
    @OneToOne
    private CarEntity car;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToOne
    private BranchEntity rentalBranch;
    @OneToOne
    private BranchEntity returnBranch;
    private Double total;

    public ReservationEntity() {
    }

    public ReservationEntity(LocalDate date, ClientEntity client, CarEntity car, LocalDate startDate, LocalDate endDate, BranchEntity rentalBranch, BranchEntity returnBranch, Double total) {
        this.date = date;
        this.client = client;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentalBranch = rentalBranch;
        this.returnBranch = returnBranch;
        this.total = total;
    }

    public Reservation mapToReservation(){
        Reservation reservation = new Reservation(date, client.mapToClient(), car.mapToCar(), startDate, endDate, rentalBranch.mapToBranch(), returnBranch.mapToBranch(), total);
        reservation.setId(id);
        return reservation;
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

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
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

    public BranchEntity getRentalBranch() {
        return rentalBranch;
    }

    public void setRentalBranch(BranchEntity rentalBranch) {
        this.rentalBranch = rentalBranch;
    }

    public BranchEntity getReturnBranch() {
        return returnBranch;
    }

    public void setReturnBranch(BranchEntity returnBranch) {
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
        ReservationEntity that = (ReservationEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(client, that.client) &&
                Objects.equals(car, that.car) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(rentalBranch, that.rentalBranch) &&
                Objects.equals(returnBranch, that.returnBranch) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, client, car, startDate, endDate, rentalBranch, returnBranch, total);
    }
}


