package prodavnica.dto;

import prodavnica.model.Roba;

public class RobaDTO {

	private Long id;
	private String naziv;
	
	public RobaDTO() {	
	}

	public RobaDTO(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public RobaDTO(Roba roba) {
		this.id = roba.getId();
		this.naziv = roba.getNaziv();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
}
