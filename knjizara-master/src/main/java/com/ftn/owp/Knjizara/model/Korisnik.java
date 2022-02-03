package com.ftn.owp.Knjizara.model;

import java.util.Date;

public class Korisnik {
	private int id;
	private String korisnickoIme;
	private String lozinka;
	private String email;
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private String adresa;
	private String brojTelefona;
	private Date datumVremeRegistracije;
	private Uloga uloga;
	private boolean blokiran;
	public Korisnik(String korisnickoIme, String lozinka, String email, String ime, String prezime,
			Date datumRodjenja, String adresa, String brojTelefona, boolean blokiran) {
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.blokiran = blokiran;
	}
	public Korisnik(int id, String korisnickoIme, String lozinka, String email, String ime, String prezime,
			Date datumRodjenja, String adresa, String brojTelefona, Date datumVremeRegistracije, Uloga uloga, boolean blokiran) {
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.datumVremeRegistracije = datumVremeRegistracije;
		this.uloga = uloga;
		this.blokiran = blokiran;
	}
	public boolean isAdmin() {
		return uloga.equals(Uloga.ADMINISTRATOR);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	public Date getDatumVremeRegistracije() {
		return datumVremeRegistracije;
	}
	public void setDatumVremeRegistracije(Date datumVremeRegistracije) {
		this.datumVremeRegistracije = datumVremeRegistracije;
	}
	public Uloga getUloga() {
		return uloga;
	}
	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
	public boolean isBlokiran() {
		return blokiran;
	}
	public void setBlokiran(boolean blokiran) {
		this.blokiran = blokiran;
	}
	
	
	
	
	
	
	

}
