package com.ftn.owp.Knjizara.service;

import java.util.List;

import com.ftn.owp.Knjizara.model.Zanr;


public interface ZanrService {
	Zanr findOne(int id);
	List<Zanr> findAll();
	List<Zanr> find(Long[] ids);
	Zanr save(Zanr zanr);
	List<Zanr> save(List<Zanr> zanrovi);
	Zanr update(Zanr zanr);
	List<Zanr> update(List<Zanr> zanrovi);
	Zanr delete(Long id);
	void delete(List<Long> ids);
	List<Zanr> find(String naziv);

}
