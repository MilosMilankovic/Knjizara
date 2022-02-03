package com.ftn.owp.Knjizara.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.owp.Knjizara.dao.KorisnikDAO;
import com.ftn.owp.Knjizara.dao.KupovinaDAO;
import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.Kupovina;
import com.ftn.owp.Knjizara.model.Uloga;
import com.ftn.owp.Knjizara.service.KorisnikService;


@Service
public class KorisnikServiceImpl implements KorisnikService {
	@Autowired
	KorisnikDAO korisnikDAO;
	
	@Autowired
	KupovinaDAO kupovinaDAO;

	@Override
	public Korisnik findOne(String korisnickoIme) {
		// TODO Auto-generated method stub
		return korisnikDAO.findOne(korisnickoIme);
	}

	@Override
	public Korisnik findOne(String korisnickoIme, String lozinka) {
		// TODO Auto-generated method stub
		return korisnikDAO.findOne(korisnickoIme, lozinka);
	}
	
	@Override
	public Korisnik findOne(int korisnikId) {
		return korisnikDAO.findOne(korisnikId);
	}
/*	@
 * proverimo da li je kupio
 * imati neku promenljivu
 * i sakriva
 */

	@Override
	public List<Korisnik> findAll() {
		// TODO Auto-generated method stub
		return korisnikDAO.findAll();
	}

	@Override
	public Korisnik save(Korisnik korisnik) {
		// TODO Auto-generated method stub
		korisnikDAO.save(korisnik);
		return null;
	}

	@Override
	public List<Korisnik> save(List<Korisnik> korisnici) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Korisnik update(Korisnik korisnik) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Korisnik> update(List<Korisnik> korisnici) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Korisnik delete(String korisnickoIme) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(List<String> korisnickaImena) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Korisnik> find(String korisnickoIme, String eMail, String pol, Boolean administrator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Korisnik> findByKorisnickoIme(String korisnickoIme) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean kupioKnjigu(Korisnik korisnik, Knjiga knjiga) {
		// TODO Auto-generated method stub
		List<Kupovina> kupovine = kupovinaDAO.find(korisnik);
		for(Kupovina kupovina : kupovine) {
			if(kupovina.getKnjiga().getId() == knjiga.getId()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void promeniUlogu(Korisnik korisnik, Uloga uloga) {
		korisnikDAO.promeniUlogu(korisnik, uloga);
		
	}

	@Override
	public void promeniBlokStatus(Korisnik korisnik, boolean blokStatus) {
		korisnikDAO.promeniBlokStatus(korisnik, blokStatus);
	}


}
