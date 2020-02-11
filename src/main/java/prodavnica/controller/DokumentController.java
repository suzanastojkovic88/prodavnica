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

import prodavnica.dto.DokumentDTO;
import prodavnica.dto.StavkaDokumentaDTO;
import prodavnica.model.Dokument;
import prodavnica.model.StavkaDokumenta;
import prodavnica.service.DokumentService;

@RestController
public class DokumentController {

	@Autowired
	DokumentService dokumentService;

	@RequestMapping(value = "api/dokumenti", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<DokumentDTO>> getAll(Pageable page) {

		Page<Dokument> dokumenti = dokumentService.getAll(page);

		List<DokumentDTO> dokumentiDTO = new ArrayList<>();

		for (Dokument d : dokumenti) {
			DokumentDTO dokumentDTO = new DokumentDTO(d);

			for (StavkaDokumenta sd : d.getStavke()) {
				dokumentDTO.getStavke().add(new StavkaDokumentaDTO(sd));
			}
			dokumentiDTO.add(dokumentDTO);
		}

		return new ResponseEntity<>(dokumentiDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "api/dokumenti/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DokumentDTO> getOne(@PathVariable Long id) {

		Dokument dokument = dokumentService.getOne(id);

		if (dokument != null) {

			DokumentDTO dokumentDTO = new DokumentDTO(dokument);

			return new ResponseEntity<>(dokumentDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "api/dokumenti", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DokumentDTO> add(@RequestBody DokumentDTO dokumentDTO) {

		Dokument dokument = new Dokument();
		dokument.setId(dokumentDTO.getId());
		dokument.setNaziv(dokumentDTO.getNaziv());
		dokument = dokumentService.save(dokument);

		return new ResponseEntity<>(new DokumentDTO(dokument), HttpStatus.CREATED);
	}

	@RequestMapping(value = "api/dokumenti/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DokumentDTO> edit(@RequestBody DokumentDTO dokumentDTO, @PathVariable Long id) {

		Dokument dokument = dokumentService.getOne(id);

		if (dokument == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		dokument.setId(id);
		dokument.setNaziv(dokumentDTO.getNaziv());
		dokument = dokumentService.save(dokument);

		return new ResponseEntity<>(new DokumentDTO(dokument), HttpStatus.OK);
	}

	@RequestMapping(value = "api/dokumenti/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		Dokument dokument = dokumentService.getOne(id);

		if (dokument != null) {
			dokumentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}