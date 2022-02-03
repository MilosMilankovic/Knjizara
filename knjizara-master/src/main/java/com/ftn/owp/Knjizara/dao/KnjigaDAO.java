package com.ftn.owp.Knjizara.dao;

import java.util.ArrayList;
import java.util.List;

import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Zanr;

public interface KnjigaDAO {
	
	public Knjiga findOne(int id);

	public List<Knjiga> findAll();

	public List<Knjiga> find(String naziv);
	
	public List<Knjiga> findByZanr(Zanr zanr);
	
	public void save(Knjiga knjiga);

	public int [] save(ArrayList<Knjiga> knjige);
	
	public void update(Knjiga knjiga);
	
	public List<Knjiga> find(String naziv, Zanr zanr, double minCena, double maxCena, String autor, String jezik);


	public int delete(int id);
	

}
