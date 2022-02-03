package com.ftn.owp.Knjizara.model;

import java.util.Date;

public class Knjiga {
	private int id;
	private String naziv;
	private int isbn;
	private String izdavackaKuca;
	private String autor;
	private Date godinaIzdavanja;
	private String kratakOpis;
	private String slika;
	private double cena;
	private int brojStranica;
	private TipPovez tipPoveza;
	private TipPismo pismo;
	private String jezik;
	private double prosecnaOcena;
	
	public Knjiga(int id, String naziv, int isbn, String izdavackaKuca, String autor, Date godinaIzdavanja,
			String kratakOpis, String slika, double cena, int brojStranica, TipPovez tipPoveza, TipPismo pismo,
			String jezik, double prosecnaOcena) {
		super();
		
		this.id = id;
		this.naziv = naziv;
		this.isbn = isbn;
		this.izdavackaKuca = izdavackaKuca;
		this.autor = autor;
		this.godinaIzdavanja = godinaIzdavanja;
		this.kratakOpis = kratakOpis;
		this.slika = slika;
		this.cena = cena;
		this.brojStranica = brojStranica;
		this.tipPoveza = tipPoveza;
		this.pismo = pismo;
		this.jezik = jezik;
		this.prosecnaOcena = prosecnaOcena;
	}
	public Knjiga(int id, String naziv, int isbn, String izdavackaKuca, String autor, Date godinaIzdavanja,
			String kratakOpis, String slika, double cena, int brojStranica, TipPovez tipPoveza, TipPismo pismo,
			String jezik) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.isbn = isbn;
		this.izdavackaKuca = izdavackaKuca;
		this.autor = autor;
		this.godinaIzdavanja = godinaIzdavanja;
		this.kratakOpis = kratakOpis;
		this.slika = slika;
		this.cena = cena;
		this.brojStranica = brojStranica;
		this.tipPoveza = tipPoveza;
		this.pismo = pismo;
		this.jezik = jezik;
	}
	public Knjiga(String naziv, int isbn, String izdavackaKuca, String autor, Date godinaIzdavanja,
			String kratakOpis, String slika, double cena, int brojStranica, TipPovez tipPoveza, TipPismo pismo,
			String jezik) {
		super();
		this.naziv = naziv;
		this.isbn = isbn;
		this.izdavackaKuca = izdavackaKuca;
		this.autor = autor;
		this.godinaIzdavanja = godinaIzdavanja;
		this.kratakOpis = kratakOpis;
		this.slika = slika;
		this.cena = cena;
		this.brojStranica = brojStranica;
		this.tipPoveza = tipPoveza;
		this.pismo = pismo;
		this.jezik = jezik;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getIzdavackaKuca() {
		return izdavackaKuca;
	}
	public void setIzdavackaKuca(String izdavackaKuca) {
		this.izdavackaKuca = izdavackaKuca;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getGodinaIzdavanja() {
		return godinaIzdavanja;
	}
	public void setGodinaIzdavanja(Date godinaIzdavanja) {
		this.godinaIzdavanja = godinaIzdavanja;
	}
	public String getKratakOpis() {
		return kratakOpis;
	}
	public void setKratakOpis(String kratakOpis) {
		this.kratakOpis = kratakOpis;
	}
	public String getSlika() {
		return slika;
	}
	public void setSlika(String slika) {
		this.slika = slika;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public int getBrojStranica() {
		return brojStranica;
	}
	public void setBrojStranica(int brojStranica) {
		this.brojStranica = brojStranica;
	}
	public TipPovez getTipPoveza() {
		return tipPoveza;
	}
	public void setTipPoveza(TipPovez tipPoveza) {
		this.tipPoveza = tipPoveza;
	}
	public TipPismo getPismo() {
		return pismo;
	}
	public void setPismo(TipPismo pismo) {
		this.pismo = pismo;
	}
	public String getJezik() {
		return jezik;
	}
	public void setJezik(String jezik) {
		this.jezik = jezik;
	}
	public double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	
	

	
	

}
