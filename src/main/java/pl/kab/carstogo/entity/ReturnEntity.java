package pl.kab.carstogo.entity;

import pl.kab.carstogo.model.Employee;
import pl.kab.carstogo.model.Reservation;
import pl.kab.carstogo.model.Return;

import java.time.LocalDate;
import java.util.Objects;

public class ReturnEntity {
    private Integer id;
    private Employee employee;
    private LocalDate returnDate;
    private Reservation reservation;
    private double surcharge;
    private String remarks;

    public ReturnEntity() {
    }

    public ReturnEntity(Employee employee, LocalDate returnDate, Reservation reservation, double surcharge, String remarks) {
        this.employee = employee;
        this.returnDate = returnDate;
        this.reservation = reservation;
        this.surcharge = surcharge;
        this.remarks = remarks;
    }

    public Return mapToReturn(){
        Return return1 = new Return(employee, returnDate, reservation, surcharge, remarks);
        return1.setId(id);
        return return1;
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
        ReturnEntity that = (ReturnEntity) o;
        return Double.compare(that.surcharge, surcharge) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(employee, that.employee) &&
                Objects.equals(returnDate, that.returnDate) &&
                Objects.equals(reservation, that.reservation) &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, returnDate, reservation, surcharge, remarks);
    }
}
