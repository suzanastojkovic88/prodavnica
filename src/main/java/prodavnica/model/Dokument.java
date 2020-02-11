package prodavnica.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dokument")
public class Dokument {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAZIV")
	private String naziv;

	@Column(name = "IZNOS")
	private double iznos = suma();

	@OneToMany(mappedBy = "dokument", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	private Set<StavkaDokumenta> stavke = new HashSet<>();

	public double suma() {

		List<StavkaDokumenta> stavke = new ArrayList<>();

		double suma = 0.0;
		for (StavkaDokumenta sd : stavke) {
			suma += sd.getVrednost();
		}
		return suma;
	}

	public Dokument() {
	}

	public Dokument(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
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

	public double getIznos() {
		return iznos;
	}
	
	public Set<StavkaDokumenta> getStavke() {
		return stavke;
	}

	public void setStavke(Set<StavkaDokumenta> stavke) {
		this.stavke = stavke;
	}

	@Override
	public String toString() {
		return "Dokument [id=" + id + ", naziv=" + naziv + ", iznos=" + iznos + "]";
	}
}
