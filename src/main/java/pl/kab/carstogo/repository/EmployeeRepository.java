package pl.kab.carstogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kab.carstogo.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
