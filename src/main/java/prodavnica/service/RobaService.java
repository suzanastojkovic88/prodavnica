package prodavnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import prodavnica.model.Roba;
import prodavnica.repository.RobaRepository;

@Component
public class RobaService {

	@Autowired
	private RobaRepository robaRepository;

	public Page<Roba> getAll(Pageable page) {
		return robaRepository.findAll(page);
	}

	public Roba getOne(Long id) {
		return robaRepository.findOne(id);
	}

	public Roba save(Roba roba) {
		return robaRepository.save(roba);
	}

	public void remove(Long id) {
		robaRepository.delete(id);
	}
}
