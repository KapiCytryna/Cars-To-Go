package pl.kab.carstogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kab.carstogo.entity.CarEntity;
import pl.kab.carstogo.model.enums.Brand;
import pl.kab.carstogo.model.enums.Status;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {
    List<CarEntity> findByStatus(Status status);
    List<CarEntity> findByStatusAndBrand(Status status, Brand brand);
    List<CarEntity> findByBrand(Brand brand);
}
