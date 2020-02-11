package prodavnica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import prodavnica.dto.StavkaDokumentaDTO;
import prodavnica.model.Roba;
import prodavnica.model.StavkaDokumenta;
import prodavnica.service.StavkaDokumentaService;

@RestController
public class StavkaDokumentaController {

	@Autowired
	private StavkaDokumentaService stavkaDokumentaService;

	@RequestMapping(value = "api/stavke_dokumenta", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<StavkaDokumentaDTO>> getAll(Pageable page) {

		Page<StavkaDokumenta> stavke = stavkaDokumentaService.getAll(page);

		List<StavkaDokumentaDTO> stavkeDTO = new ArrayList<>();

		for (StavkaDokumenta sd : stavke) {
			stavkeDTO.add(new StavkaDokumentaDTO(sd));
		}
		return new ResponseEntity<>(stavkeDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "api/stavke_dokumenta/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<StavkaDokumentaDTO> getOne(@PathVariable Long id) {

		StavkaDokumenta stavka = stavkaDokumentaService.getOne(id);

		if (stavka != null) {
			StavkaDokumentaDTO stavkaDTO = new StavkaDokumentaDTO(stavka);

			return new ResponseEntity<>(stavkaDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "api/stavke_dokumenta", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StavkaDokumentaDTO> add(@RequestBody StavkaDokumentaDTO stavkaDTO) {

		StavkaDokumenta stavka = new StavkaDokumenta();
		stavka.setId(stavkaDTO.getId());
		stavka.setKolicina(stavkaDTO.getKolicina());
		stavka.setCena(stavkaDTO.getCena());
		stavka.setRoba(new Roba(stavkaDTO.getRoba().getId(), stavkaDTO.getRoba().getNaziv()));

		stavka = stavkaDokumentaService.save(stavka);

		return new ResponseEntity<>(new StavkaDokumentaDTO(stavka), HttpStatus.CREATED);
	}

	@RequestMapping(value = "api/stavke_dokumenta/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StavkaDokumentaDTO> edit(@PathVariable Long id, @RequestBody StavkaDokumentaDTO stavkaDTO) {

		StavkaDokumenta stavka = stavkaDokumentaService.getOne(id);

		if (stavka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		stavka.setId(id);
		stavka.setKolicina(stavkaDTO.getKolicina());
		stavka.setCena(stavkaDTO.getCena());
		stavka.setRoba(new Roba(stavkaDTO.getRoba().getId(), stavkaDTO.getRoba().getNaziv()));
		stavka = stavkaDokumentaService.save(stavka);

		return new ResponseEntity<>(new StavkaDokumentaDTO(stavka), HttpStatus.OK);
	}

	@RequestMapping(value = "api/stavke_dokumenta/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		StavkaDokumenta stavka = stavkaDokumentaService.getOne(id);

		if (stavka != null) {
			stavkaDokumentaService.remove(id);

			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}