package pl.kab.carstogo.model;

import pl.kab.carstogo.entity.RentalEntity;

import java.time.LocalDate;
import java.util.Objects;

public class Rental{
    private Integer id;
    private Employee employee;
    private LocalDate rentDate;
    private Reservation reservation;
    private String remarks;

    public Rental() {
    }

    public Rental(Employee employee, LocalDate rentDate, Reservation reservation, String remarks) {
        this.employee = employee;
        this.rentDate = rentDate;
        this.reservation = reservation;
        this.remarks = remarks;
    }

    public RentalEntity mapToRentalEntity() {
        return new RentalEntity(getEmployee().mapToEmployeeEntity(), getRentDate(), getReservation().mapToReservationEntity(), getRemark());
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

    public String getRemark() {
        return remarks;
    }

    public void setRemark(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(id, rental.id) && Objects.equals(employee, rental.employee) && Objects.equals(rentDate, rental.rentDate) && Objects.equals(reservation, rental.reservation) && Objects.equals(remarks, rental.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, rentDate, reservation, remarks);
    }
}
