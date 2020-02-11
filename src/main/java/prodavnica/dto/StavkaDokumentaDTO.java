package prodavnica.dto;

import prodavnica.model.StavkaDokumenta;

public class StavkaDokumentaDTO {

	private Long id;
	private int kolicina;
	private double cena;
	private RobaDTO roba;

	public StavkaDokumentaDTO() {
	}

	public StavkaDokumentaDTO(Long id, int kolicina, double cena, RobaDTO roba) {
		super();
		this.id = id;
		this.kolicina = kolicina;
		this.cena = cena;
		this.roba = roba;
	}

	public StavkaDokumentaDTO(StavkaDokumenta stavka) {
		this.id = stavka.getId();
		this.kolicina = stavka.getKolicina();
		this.cena = stavka.getCena();
		this.roba = new RobaDTO(stavka.getRoba());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public RobaDTO getRoba() {
		return roba;
	}

	public void setRoba(RobaDTO roba) {
		this.roba = roba;
	}
}
