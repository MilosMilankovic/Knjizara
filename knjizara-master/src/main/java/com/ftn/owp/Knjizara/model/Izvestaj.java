package com.ftn.owp.Knjizara.model;

public class Izvestaj {
	private Knjiga knjiga;
	private int brojProdatihPrimeraka;
	public Izvestaj(Knjiga knjiga, int brojProdatihPrimeraka) {
		super();
		this.knjiga = knjiga;
		this.brojProdatihPrimeraka = brojProdatihPrimeraka;
	}
	public Knjiga getKnjiga() {
		return knjiga;
	}
	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}
	public int getBrojProdatihPrimeraka() {
		return brojProdatihPrimeraka;
	}
	public void setBrojProdatihPrimeraka(int brojProdatihPrimeraka) {
		this.brojProdatihPrimeraka = brojProdatihPrimeraka;
	}
	
	public double ukupnaCena() {
		return knjiga.getCena()*brojProdatihPrimeraka;
	}
}
