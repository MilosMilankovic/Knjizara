package com.ftn.owp.Knjizara.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.owp.Knjizara.dao.ZanrDAO;
import com.ftn.owp.Knjizara.model.Zanr;
import com.ftn.owp.Knjizara.service.ZanrService;

@Service
public class ZanrServiceImpl implements ZanrService {
	@Autowired
	ZanrDAO zanrDAO;

	@Override
	public Zanr findOne(int id) {
		// TODO Auto-generated method stub
		return zanrDAO.findOne(id);
	}

	@Override
	public List<Zanr> findAll() {
		// TODO Auto-generated method stub
		return zanrDAO.findAll();
	}

	@Override
	public List<Zanr> find(Long[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Zanr save(Zanr zanr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zanr> save(List<Zanr> zanrovi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Zanr update(Zanr zanr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zanr> update(List<Zanr> zanrovi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Zanr delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(List<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Zanr> find(String naziv) {
		// TODO Auto-generated method stub
		return null;
	}

}
