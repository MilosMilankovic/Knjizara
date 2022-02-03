package com.ftn.owp.Knjizara.model;

import java.util.Date;

public class Komentar {
	private int id;
	private String tekst;
	private int ocena;
	private Date datum;
	private Korisnik autor;
	private Knjiga knjiga;
	private StatusTip status;
	public Komentar(int id, String tekst, int ocena, Date datum, Korisnik autor, Knjiga knjiga, StatusTip status) {
		this.id = id;
		this.tekst = tekst;
		this.ocena = ocena;
		this.datum = datum;
		this.autor = autor;
		this.knjiga = knjiga;
		this.status = status;
	}
	public Komentar(String tekst, int ocena, Date datum, Korisnik autor, Knjiga knjiga, StatusTip status) {
		this.tekst = tekst;
		this.ocena = ocena;
		this.datum = datum;
		this.autor = autor;
		this.knjiga = knjiga;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Korisnik getAutor() {
		return autor;
	}
	public void setAutor(Korisnik autor) {
		this.autor = autor;
	}
	public Knjiga getKnjiga() {
		return knjiga;
	}
	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}
	public StatusTip getStatus() {
		return status;
	}
	public void setStatus(StatusTip status) {
		this.status = status;
	}
	
	

}
