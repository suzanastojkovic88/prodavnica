package prodavnica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stavka_dokumenta")
public class StavkaDokumenta {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "KOLICINA")
	private int kolicina;

	@Column(name = "CENA")
	private double cena;
	
	private double vrednost = kolicina*cena;

	@ManyToOne(fetch = FetchType.EAGER)
	private Roba roba;
	
/*	public double proizvod() {
		
		StavkaDokumenta sd = new StavkaDokumenta();
		double vrednostStavke = sd.getKolicina()*sd.getCena();
		return vrednostStavke;
	}
*/
	public StavkaDokumenta() {
	}

	public StavkaDokumenta(Long id, int kolicina, double cena) {
		this.id = id;
		this.kolicina = kolicina;
		this.cena = cena;
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

	public double getVrednost() {
		return vrednost;
	}

	public Roba getRoba() {
		return roba;
	}

	public void setRoba(Roba roba) {
		this.roba = roba;
	}
	
	@Override
	public String toString() {
		return "StavkaDokumenta [id=" + id + ", kolicina=" + kolicina + ", cena=" + cena + ", roba=" + roba + "]";
	}
}
