package com.ftn.owp.Knjizara.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.owp.Knjizara.dao.KomentarDAO;
import com.ftn.owp.Knjizara.model.Komentar;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.StatusTip;
import com.ftn.owp.Knjizara.service.KomentarService;

@Service
public class KomentarServiceImpl implements KomentarService {
	
	
	@Autowired
	KomentarDAO komentarDAO;

	@Override
	public Komentar findOne(int id) {
		// TODO Auto-generated method stub
		return komentarDAO.findOne(id);
	}

	@Override
	public List<Komentar> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Komentar komentar) {
		// TODO Auto-generated method stub
		komentarDAO.save(komentar);
	}

	@Override
	public void update(Komentar komentar) {
		// TODO Auto-generated method stub
		komentarDAO.update(komentar);
	}

	@Override
	public Komentar delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public List<Komentar> findByKnjigaId(int id) {
		// TODO Auto-generated method stub
		return komentarDAO.findByKnjigaId(id);
	}

	@Override
	public List<Komentar> findByKorisnikId(int id) {
		// TODO Auto-generated method stub
		return komentarDAO.findByKorisnikId(id);
	}

	@Override
	public boolean postavioKomentar(Korisnik korisnik, List<Komentar> komentari) {
		// TODO Auto-generated method stub
		for(Komentar komentar : komentari) {
			if(komentar.getAutor().getId() == korisnik.getId()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Komentar> findByStatus(StatusTip status) {
		// TODO Auto-generated method stub
		return komentarDAO.findByStatus(status);
	}

	@Override
	public void promeniStatus(Komentar komentar, StatusTip status) {
		// TODO Auto-generated method stub
		komentar.setStatus(status);
		komentarDAO.update(komentar);
		
	}

}
