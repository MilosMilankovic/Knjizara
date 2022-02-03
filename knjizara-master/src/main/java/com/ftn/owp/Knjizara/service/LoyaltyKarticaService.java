package com.ftn.owp.Knjizara.service;

import java.util.List;

import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.LoyaltyKartica;
import com.ftn.owp.Knjizara.model.StatusTip;


public interface LoyaltyKarticaService {
	LoyaltyKartica findOne(int id);
	List<LoyaltyKartica> findAll();
	void save(LoyaltyKartica loyaltyKartica);
	LoyaltyKartica update(LoyaltyKartica loyaltyKartica);
	LoyaltyKartica delete(Long id);
	void promeniStatus(int id, StatusTip odobren);
	boolean odobrenZahtev(Korisnik prijavljeniKorisnik);
	void dodajBrojPoena(int poeni, int korisnikId);
	boolean podnesenZahtev(Korisnik prijavljeniKorisnik);
	LoyaltyKartica findByKorisnikId(int korisnikId);
}
