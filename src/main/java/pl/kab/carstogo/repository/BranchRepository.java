package pl.kab.carstogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kab.carstogo.entity.BranchEntity;

public interface BranchRepository extends JpaRepository<BranchEntity, Integer> {
}

