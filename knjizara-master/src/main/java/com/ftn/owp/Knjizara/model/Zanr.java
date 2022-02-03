package com.ftn.owp.Knjizara.model;

public class Zanr {
	private int id;
	private String ime;
	private String opis;
	public Zanr(int id, String ime, String opis) {
		this.id = id;
		this.ime = ime;
		this.opis = opis;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	

}
