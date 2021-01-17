package pl.kab.carstogo.entity;

import pl.kab.carstogo.model.Employee;
import pl.kab.carstogo.model.Rental;
import pl.kab.carstogo.model.Reservation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class RentalEntity {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    private EmployeeEntity employee;
    private LocalDate rentDate;
    @OneToOne
    private ReservationEntity reservation;
    private String remarks;

    public RentalEntity() {
    }

    public RentalEntity(EmployeeEntity employee, LocalDate rentDate, ReservationEntity reservation, String remarks) {
        this.employee = employee;
        this.rentDate = rentDate;
        this.reservation = reservation;
        this.remarks = remarks;
    }

    public Rental mapToRental(){
        Rental rental = new Rental(employee.mapToEmployee(),rentDate,reservation.mapToReservation(),remarks);
        rental.setId(id);
        return rental;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public ReservationEntity getReservation() {
        return reservation;
    }

    public void setReservation(ReservationEntity reservation) {
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
