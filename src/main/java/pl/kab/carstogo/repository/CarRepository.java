package pl.kab.carstogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kab.carstogo.entity.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {
}
