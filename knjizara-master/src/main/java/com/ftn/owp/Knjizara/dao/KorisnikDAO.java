package com.ftn.owp.Knjizara.dao;

import java.util.List;

import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.Uloga;


public interface KorisnikDAO {
	public Korisnik findOne(String korisnickoIme);

	public Korisnik findOne(String korisnickoIme, String lozinka);

	public List<Korisnik> findAll();
	
	public Korisnik findOne(int id);

	public List<Korisnik> find(String korisnickoIme, String eMail, String pol, Boolean administrator);
	
	public void save(Korisnik korisnik);

	public void update(Korisnik korisnik);

	public void delete(String korisnickoIme);
	public void promeniUlogu(Korisnik korisnik, Uloga uloga);

	void promeniBlokStatus(Korisnik korisnik, boolean blokStatus);

}
