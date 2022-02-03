package com.ftn.owp.Knjizara.dao;

import java.util.ArrayList;
import java.util.List;

import com.ftn.owp.Knjizara.model.Zanr;


public interface ZanrDAO {
	public Zanr findOne(int id);

	public List<Zanr> findAll();

	public List<Zanr> find(String naziv);
	
	public int save(Zanr zanr);

	public int [] save(ArrayList<Zanr> zanrovi);
	
	public int update(Zanr zanr);

	public int delete(int id);

}
