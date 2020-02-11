package prodavnica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roba")
public class Roba {
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="NAZIV")
	private String naziv;
	
	public Roba() {
	}

	public Roba(Long id, String naziv) {
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

	@Override
	public String toString() {
		return "Roba [id=" + id + ", naziv=" + naziv + "]";
	}
}
