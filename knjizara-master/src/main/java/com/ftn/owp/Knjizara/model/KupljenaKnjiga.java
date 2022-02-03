package com.ftn.owp.Knjizara.model;

public class KupljenaKnjiga {
	private int id;
	private Knjiga knjiga;
	private int brojPrimeraka;
	private double cena;
	public KupljenaKnjiga(int id, Knjiga knjiga, int brojPrimeraka, double cena) {
		this.id = id;
		this.knjiga = knjiga;
		this.brojPrimeraka = brojPrimeraka;
		this.cena = cena;
	}
	public KupljenaKnjiga(Knjiga knjiga, int brojPrimeraka, double cena) {
		this.knjiga = knjiga;
		this.brojPrimeraka = brojPrimeraka;
		this.cena = cena;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Knjiga getKnjiga() {
		return knjiga;
	}
	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}
	public int getBrojPrimeraka() {
		return brojPrimeraka;
	}
	public void setBrojPrimeraka(int brojPrimeraka) {
		this.brojPrimeraka = brojPrimeraka;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	
	

}
