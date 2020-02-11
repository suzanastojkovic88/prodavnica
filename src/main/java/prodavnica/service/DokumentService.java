package prodavnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import prodavnica.model.Dokument;
import prodavnica.repository.DokumentRepository;

@Component
public class DokumentService {

	@Autowired
	private DokumentRepository dokumentRepository;

	public List<Dokument> getAll() {
		return dokumentRepository.findAll();
	}

	public Page<Dokument> getAll(Pageable page) {
		return dokumentRepository.findAll(page);
	}

	public Dokument getOne(Long id) {
		return dokumentRepository.findOne(id);
	}

	public Dokument save(Dokument dokument) {
		return dokumentRepository.save(dokument);
	}

	public void remove(Long id) {
		dokumentRepository.delete(id);
	}
}
