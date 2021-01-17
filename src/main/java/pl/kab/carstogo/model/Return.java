package pl.kab.carstogo.model;

import pl.kab.carstogo.entity.ReturnEntity;

import java.time.LocalDate;
import java.util.Objects;

public class Return {
    private Integer id;
    private Employee employee;
    private LocalDate returnDate;
    private Reservation reservation;
    private double surcharge;
    private String remarks;

    public Return() {
    }

    public Return(Employee employee, LocalDate returnDate, Reservation reservation, double surcharge, String remarks) {
        this.employee = employee;
        this.returnDate = returnDate;
        this.reservation = reservation;
        this.surcharge = surcharge;
        this.remarks = remarks;
    }

    public ReturnEntity mapToReturnEntity() {
        return new ReturnEntity(getEmployee().mapToEmployeeEntity(), getReturnDate(), getReservation().mapToReservationEntity(), getSurcharge(), getRemarks());
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

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(double surcharge) {
        this.surcharge = surcharge;
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
        Return aReturn = (Return) o;
        return Double.compare(aReturn.surcharge, surcharge) == 0 && Objects.equals(id, aReturn.id) && Objects.equals(employee, aReturn.employee) && Objects.equals(returnDate, aReturn.returnDate) && Objects.equals(reservation, aReturn.reservation) && Objects.equals(remarks, aReturn.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, returnDate, reservation, surcharge, remarks);
    }
}
