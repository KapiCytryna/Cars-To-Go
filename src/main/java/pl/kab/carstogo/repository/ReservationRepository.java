package pl.kab.carstogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kab.carstogo.entity.ReservationEntity;

public interface ReservationRepository  extends JpaRepository<ReservationEntity, Integer> {
}
