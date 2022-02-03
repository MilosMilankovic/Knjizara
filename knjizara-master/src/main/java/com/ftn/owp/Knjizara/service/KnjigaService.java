package com.ftn.owp.Knjizara.service;

import java.util.List;

import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Zanr;


public interface KnjigaService {
	Knjiga findOne(int id);
	List<Knjiga> findAll();
	void save(Knjiga knjiga);
	void update(Knjiga knjiga);
	Knjiga delete(int id);
	List<Knjiga> find(String naziv, Zanr zanr, double minCena, double maxCena, String autor, String jezik);
	
	Knjiga findByISBN(int isbn);

	
	
}
