package prodavnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import prodavnica.model.StavkaDokumenta;

@Component
public interface StavkaDokumentaRepository extends JpaRepository<StavkaDokumenta, Long> {
	
}
