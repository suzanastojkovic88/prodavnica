package prodavnica.dto;

import java.util.ArrayList;
import java.util.List;

import prodavnica.model.Dokument;

public class DokumentDTO {
	
	private Long id;
	private String naziv;
	private List<StavkaDokumentaDTO> stavke = new ArrayList<>();
	
	public DokumentDTO() {	
	}
	
	public DokumentDTO(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public DokumentDTO(Dokument dokument) {
		this.id = dokument.getId();
		this.naziv = dokument.getNaziv();
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
	
	public List<StavkaDokumentaDTO> getStavke() {
		return stavke;
	}

	public void setStavke(List<StavkaDokumentaDTO> stavke) {
		this.stavke = stavke;
	}	
}
