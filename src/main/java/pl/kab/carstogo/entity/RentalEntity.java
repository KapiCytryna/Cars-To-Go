package pl.kab.carstogo.entity;

import pl.kab.carstogo.model.Employee;
import pl.kab.carstogo.model.Rental;
import pl.kab.carstogo.model.Reservation;

import java.time.LocalDate;
import java.util.Objects;

public class RentalEntity {
    private Integer id;
    private Employee employee;
    private LocalDate rentDate;
    private Reservation reservation;
    private String remarks;

    public RentalEntity() {
    }

    public RentalEntity(Integer id, Employee employee, LocalDate rentDate, Reservation reservation, String remarks) {
        this.id = id;
        this.employee = employee;
        this.rentDate = rentDate;
        this.reservation = reservation;
        this.remarks = remarks;
    }

    public Rental mapToRental(){
        Rental rental = new Rental(employee,rentDate,reservation,remarks);
        rental.setId(id);
        return rental;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalEntity that = (RentalEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(employee, that.employee) &&
                Objects.equals(rentDate, that.rentDate) &&
                Objects.equals(reservation, that.reservation) &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, rentDate, reservation, remarks);
    }
}
