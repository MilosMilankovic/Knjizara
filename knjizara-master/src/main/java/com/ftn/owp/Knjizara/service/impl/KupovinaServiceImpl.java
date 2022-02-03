package com.ftn.owp.Knjizara.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.owp.Knjizara.dao.KupovinaDAO;
import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.Kupovina;
import com.ftn.owp.Knjizara.service.KupovinaService;


@Service
public class KupovinaServiceImpl implements KupovinaService {
	
	@Autowired
	KupovinaDAO kupovinaDAO;

	@Override
	public Kupovina findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kupovina> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Kupovina kupovina) {
		// TODO Auto-generated method stub
		kupovinaDAO.save(kupovina);
	}

	@Override
	public Kupovina update(Kupovina kupovina) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kupovina delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kupovina> find(Korisnik korisnik) {
		// TODO Auto-generated method stub
		return kupovinaDAO.find(korisnik);
	}
	@Override
	public List<Kupovina> find(Knjiga knjiga) {
		// TODO Auto-generated method stub
		return kupovinaDAO.find(knjiga);
	}

}
