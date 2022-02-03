package com.ftn.owp.Knjizara.dao;

import java.util.ArrayList;
import java.util.List;

import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.Kupovina;

public interface KupovinaDAO {
	public Kupovina findOne(int id);

	public List<Kupovina> findAll();

	public List<Kupovina> find(String naziv);
	
	public void save(Kupovina kupovina);

	public int [] save(ArrayList<Kupovina> kupovine);
	
	public int update(Kupovina kupovina);

	
	public int delete(int id);
	
	public List<Kupovina> find(Korisnik korisnik);
	public List<Kupovina> find(Knjiga knjiga);

}
