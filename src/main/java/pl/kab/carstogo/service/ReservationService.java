package pl.kab.carstogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kab.carstogo.entity.ReservationEntity;
import pl.kab.carstogo.model.Reservation;
import pl.kab.carstogo.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> findAll(){
        return reservationRepository.findAll().stream()
                .map(ReservationEntity::mapToReservation)
                .collect(Collectors.toList());
    }

    public Reservation addReservation (Reservation reservation){
       ReservationEntity reservationEntity = reservationRepository
               .save(reservation.mapToReservationEntity());
       return reservationEntity.mapToReservation();
    }

    public Reservation findById(Integer id) {
        return findEntityById(id).mapToReservation();
    }

    public ReservationEntity findEntityById(Integer id) {
        return reservationRepository.findById(id).orElseThrow();
    }

    public void remove (Integer id) {
        reservationRepository.deleteById(id);
    }

    public Reservation update(Integer id, Reservation reservation) {
        ReservationEntity reservationEntity = reservationRepository.findById(id).orElseThrow();
        Optional.ofNullable(reservation.getDate()).ifPresent(reservationEntity::setDate);
        Optional.ofNullable(reservation.getCar()).ifPresent(e -> reservationEntity.setCar(
                e.mapToCarEntity()));
        Optional.ofNullable(reservation.getStartDate()).ifPresent(reservationEntity::setStartDate);
        Optional.ofNullable(reservation.getEndDate()).ifPresent(reservationEntity::setEndDate);
        Optional.ofNullable(reservation.getReturnBranch()).ifPresent(e -> reservationEntity.setReturnBranch(
                e.mapToBranchEntity()));
        Optional.ofNullable(reservation.getTotal()).ifPresent(reservationEntity::setTotal);
        reservationRepository.save(reservationEntity);
        return reservationEntity.mapToReservation();
    }





}
