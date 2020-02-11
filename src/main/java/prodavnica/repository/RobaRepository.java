package prodavnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import prodavnica.model.Roba;

@Component
public interface RobaRepository extends JpaRepository<Roba, Long> {

}