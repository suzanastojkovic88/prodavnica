package prodavnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import prodavnica.model.Dokument;

@Component
public interface DokumentRepository extends JpaRepository<Dokument, Long> {

}