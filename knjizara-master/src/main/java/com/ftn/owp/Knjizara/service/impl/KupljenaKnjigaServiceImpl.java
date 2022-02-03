package com.ftn.owp.Knjizara.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.owp.Knjizara.dao.KupljenaKnjigaDAO;
import com.ftn.owp.Knjizara.model.KupljenaKnjiga;
import com.ftn.owp.Knjizara.service.KupljenaKnjigaService;

@Service
public class KupljenaKnjigaServiceImpl implements KupljenaKnjigaService {
	@Autowired
	KupljenaKnjigaDAO kupljenaKnjigaDAO;

	@Override
	public KupljenaKnjiga findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KupljenaKnjiga> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(KupljenaKnjiga kupljenaKnjiga) {
		// TODO Auto-generated method stub
		kupljenaKnjigaDAO.save(kupljenaKnjiga);
	}

	@Override
	public KupljenaKnjiga update(KupljenaKnjiga kupljenaKnjiga) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KupljenaKnjiga delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
