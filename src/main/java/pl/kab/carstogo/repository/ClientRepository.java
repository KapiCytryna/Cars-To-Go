package pl.kab.carstogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kab.carstogo.entity.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Integer> {
}
