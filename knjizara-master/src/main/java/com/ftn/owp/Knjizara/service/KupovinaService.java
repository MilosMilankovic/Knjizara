package com.ftn.owp.Knjizara.service;

import java.util.List;

import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.Kupovina;


public interface KupovinaService {
	Kupovina findOne(Long id);
	List<Kupovina> findAll();
	
	void save(Kupovina kupovina);
	Kupovina update(Kupovina kupovina);
	Kupovina delete(Long id);
	List<Kupovina> find(Korisnik korisnik);
	List<Kupovina> find(Knjiga knjiga);
	

}
