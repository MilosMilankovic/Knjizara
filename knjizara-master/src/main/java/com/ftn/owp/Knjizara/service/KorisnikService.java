package com.ftn.owp.Knjizara.service;

import java.util.List;

import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.Uloga;


public interface KorisnikService {

	Korisnik findOne(String korisnickoIme);
	Korisnik findOne(String korisnickoIme, String lozinka);
	List<Korisnik> findAll();
	Korisnik save(Korisnik korisnik);
	List<Korisnik> save(List<Korisnik> korisnici);
	Korisnik update(Korisnik korisnik);
	List<Korisnik> update(List<Korisnik> korisnici);
	Korisnik delete(String korisnickoIme);
	void delete(List<String> korisnickaImena);
	List<Korisnik> find(String korisnickoIme, String eMail, String pol, Boolean administrator);
	List<Korisnik> findByKorisnickoIme(String korisnickoIme);
	
	boolean kupioKnjigu(Korisnik korisnik, Knjiga knjiga);
	
	
	void promeniUlogu(Korisnik korisnik, Uloga uloga);
	Korisnik findOne(int korisnikId);
	void promeniBlokStatus(Korisnik korisnik, boolean blokStatus);


}
