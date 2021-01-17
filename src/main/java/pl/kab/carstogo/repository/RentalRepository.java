package pl.kab.carstogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kab.carstogo.entity.RentalEntity;

public interface RentalRepository extends JpaRepository<RentalEntity, Integer> {
}
