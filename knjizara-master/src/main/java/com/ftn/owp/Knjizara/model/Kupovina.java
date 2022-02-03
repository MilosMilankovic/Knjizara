package com.ftn.owp.Knjizara.model;

import java.util.Date;
import java.util.List;

public class Kupovina {
	private int id;
	private Knjiga knjiga;
	private double cena;
	private Date datum;
	private Korisnik korisnik;
	public Kupovina(int id, Knjiga knjiga, double cena, Date datum, Korisnik korisnik) {
		super();
		this.id = id;
		this.knjiga = knjiga;
		this.cena = cena;
		this.datum = datum;
		this.korisnik = korisnik;
	}
	public Kupovina(Knjiga knjiga, double cena, Korisnik korisnik) {
		super();
		this.knjiga = knjiga;
		this.cena = cena;
		this.korisnik = korisnik;
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
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	
	
	
}
