package com.ftn.owp.Knjizara.model;

public class LoyaltyKartica {
	private int id;
	private double popust;
	private int brojPoena;
	private Korisnik korisnik;
	
	private StatusTip status;
	public LoyaltyKartica(int id, double popust, int brojPoena, Korisnik korisnik, StatusTip status) {
		super();
		this.id = id;
		this.popust = popust;
		this.brojPoena = brojPoena;
		this.korisnik = korisnik;
		this.status = status;
	}
	
	public LoyaltyKartica(double popust, int brojPoena, Korisnik korisnik, StatusTip status) {
		this.popust = popust;
		this.brojPoena = brojPoena;
		this.korisnik = korisnik;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPopust() {
		return popust;
	}
	public void setPopust(double popust) {
		this.popust = popust;
	}
	public int getBrojPoena() {
		return brojPoena;
	}
	public void setBrojPoena(int brojPoena) {
		this.brojPoena = brojPoena;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public StatusTip getStatus() {
		return status;
	}
	public void setStatus(StatusTip status) {
		this.status = status;
	}
	
	
	
	
	

}
