package com.ftn.owp.Knjizara.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.owp.Knjizara.dao.LoyaltyKarticaDAO;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.LoyaltyKartica;
import com.ftn.owp.Knjizara.model.StatusTip;
import com.ftn.owp.Knjizara.service.LoyaltyKarticaService;

@Service
public class LoyaltyKarticaServiceImpl implements LoyaltyKarticaService {
	@Autowired
	LoyaltyKarticaDAO loyaltyKarticaDAO;

	@Override
	public LoyaltyKartica findOne(int id) {
		// TODO Auto-generated method stub
		return loyaltyKarticaDAO.findOne(id);
	}

	@Override
	public List<LoyaltyKartica> findAll() {
		// TODO Auto-generated method stub
		return loyaltyKarticaDAO.findAll();
	}

	@Override
	public void save(LoyaltyKartica loyaltyKartica) {
		// TODO Auto-generated method stub
		loyaltyKarticaDAO.save(loyaltyKartica);
	}

	@Override
	public LoyaltyKartica update(LoyaltyKartica loyaltyKartica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoyaltyKartica delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void promeniStatus(int id, StatusTip odobren) {
		loyaltyKarticaDAO.promeniStatus(id, odobren);
		
	}

	@Override
	public boolean odobrenZahtev(Korisnik prijavljeniKorisnik) {
		// TODO Auto-generated method stub
		return loyaltyKarticaDAO.odobrenZahtev(prijavljeniKorisnik);
	}
	
	@Override
	public boolean podnesenZahtev(Korisnik prijavljeniKorisnik) {
		return loyaltyKarticaDAO.podnesenZahtev(prijavljeniKorisnik);
	}

	@Override
	public void dodajBrojPoena(int poeni, int korisnikId) {
		loyaltyKarticaDAO.dodajBrojPoena(poeni, korisnikId);
		
	}
	@Override
	public LoyaltyKartica findByKorisnikId(int korisnikId) {
		return loyaltyKarticaDAO.findByKorisnikId(korisnikId);
		
	}


}
