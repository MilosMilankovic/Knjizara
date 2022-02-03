package com.ftn.owp.Knjizara.model;

public class KnjigaIKolicina {
	private Knjiga knjiga;
	private int kolicina;
	public KnjigaIKolicina(Knjiga knjiga, int kolicina) {
		super();
		this.knjiga = knjiga;
		this.kolicina = kolicina;
	}
	public Knjiga getKnjiga() {
		return knjiga;
	}
	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	

}
