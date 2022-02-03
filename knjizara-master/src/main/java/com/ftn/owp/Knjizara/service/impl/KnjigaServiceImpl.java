package com.ftn.owp.Knjizara.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.owp.Knjizara.dao.KnjigaDAO;
import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Zanr;
import com.ftn.owp.Knjizara.service.KnjigaService;

@Service
public class KnjigaServiceImpl implements KnjigaService {
	@Autowired
	KnjigaDAO knjigaDAO;

	@Override
	public Knjiga findOne(int id) {
		// TODO Auto-generated method stub
		return knjigaDAO.findOne(id);
	}

	@Override
	public List<Knjiga> findAll() {
		// TODO Auto-generated method stub
		return knjigaDAO.findAll();
	
		
	}

	@Override
	public void save(Knjiga knjiga) {
		// TODO Auto-generated method stub
		knjigaDAO.save(knjiga);
		
	}

	@Override
	public void update(Knjiga knjiga) {
		// TODO Auto-generated method stub
		knjigaDAO.update(knjiga);
	}

	@Override
	public Knjiga delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Knjiga> find(String naziv, Zanr zanr, double minCena, double maxCena, String autor, String jezik) {
		// TODO Auto-generated method stub
		return knjigaDAO.find(naziv, zanr, minCena, maxCena, autor, jezik);
	
	}

	@Override
	public Knjiga findByISBN(int isbn) {
		// TODO Auto-generated method stub
		List<Knjiga> knjige = findAll();
		for(Knjiga knjiga : knjige) {
			if(knjiga.getIsbn() == isbn) {
				return knjiga;
			}
		}
		return null;
	}
	

}
