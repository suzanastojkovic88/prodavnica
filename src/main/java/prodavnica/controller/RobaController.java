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

import prodavnica.dto.RobaDTO;
import prodavnica.model.Roba;
import prodavnica.service.RobaService;

@RestController
public class RobaController {

	@Autowired
	RobaService robaService;

	@RequestMapping(value = "api/roba_lista", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<RobaDTO>> getAll(Pageable page) {

		Page<Roba> robaLista = robaService.getAll(page);

		List<RobaDTO> listaDTO = new ArrayList<>();

		for (Roba roba : robaLista) {
			listaDTO.add(new RobaDTO(roba));
		}
		return new ResponseEntity<>(listaDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "api/roba_lista/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RobaDTO> getOne(@PathVariable Long id) {

		Roba roba = robaService.getOne(id);

		if (roba != null) {
			RobaDTO robaDTO = new RobaDTO(roba);
			return new ResponseEntity<>(robaDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "api/roba_lista", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RobaDTO> add(@RequestBody RobaDTO robaDTO) {

		Roba roba = new Roba();
		roba.setId(robaDTO.getId());
		roba.setNaziv(robaDTO.getNaziv());
		roba = robaService.save(roba);

		return new ResponseEntity<>(new RobaDTO(roba), HttpStatus.CREATED);
	}

	@RequestMapping(value = "api/roba_lista/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RobaDTO> edit(@PathVariable Long id, @RequestBody RobaDTO robaDTO) {

		Roba roba = robaService.getOne(id);

		if (roba == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		roba.setId(id);
		roba.setNaziv(robaDTO.getNaziv());
		roba = robaService.save(roba);

		return new ResponseEntity<>(new RobaDTO(roba), HttpStatus.OK);
	}

	@RequestMapping(value = "api/roba_lista{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		Roba roba = robaService.getOne(id);

		if (roba != null) {
			robaService.remove(id);

			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
