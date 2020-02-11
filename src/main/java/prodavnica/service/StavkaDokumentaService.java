package prodavnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import prodavnica.model.StavkaDokumenta;
import prodavnica.repository.StavkaDokumentaRepository;

@Component
public class StavkaDokumentaService {

	@Autowired
	private StavkaDokumentaRepository stavkaRepository;

	public Page<StavkaDokumenta> getAll(Pageable page) {
		return stavkaRepository.findAll(page);
	}

	public StavkaDokumenta getOne(Long id) {
		return stavkaRepository.findOne(id);
	}

	public StavkaDokumenta save(StavkaDokumenta stavkaDokumenta) {
		return stavkaRepository.save(stavkaDokumenta);
	}

	public void remove(Long id) {
		stavkaRepository.delete(id);
	}
}
