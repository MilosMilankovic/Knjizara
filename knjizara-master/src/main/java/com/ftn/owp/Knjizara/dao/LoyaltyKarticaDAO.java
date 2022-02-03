package com.ftn.owp.Knjizara.dao;

import java.util.ArrayList;
import java.util.List;

import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.LoyaltyKartica;
import com.ftn.owp.Knjizara.model.StatusTip;

public interface LoyaltyKarticaDAO {
	public LoyaltyKartica findOne(int id);

	public List<LoyaltyKartica> findAll();

	public List<LoyaltyKartica> find(String naziv);
	
	public void save(LoyaltyKartica loyaltyKartica);

	public int [] save(ArrayList<LoyaltyKartica> loyaltyKartice);
	
	public int update(LoyaltyKartica loyaltyKartica);

	public int delete(int id);

	public void promeniStatus(int id, StatusTip odobren);

	public boolean odobrenZahtev(Korisnik prijavljeniKorisnik);


	void dodajBrojPoena(int poeni, int id);

	public boolean podnesenZahtev(Korisnik prijavljeniKorisnik);

	LoyaltyKartica findByKorisnikId(int korisnikId);

}
