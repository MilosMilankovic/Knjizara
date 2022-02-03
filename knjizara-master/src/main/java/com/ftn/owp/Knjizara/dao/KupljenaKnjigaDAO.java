package com.ftn.owp.Knjizara.dao;

import java.util.ArrayList;
import java.util.List;

import com.ftn.owp.Knjizara.model.KupljenaKnjiga;

public interface KupljenaKnjigaDAO {
	public KupljenaKnjiga findOne(int id);

	public List<KupljenaKnjiga> findAll();

	public List<KupljenaKnjiga> find(String naziv);
	
	public void save(KupljenaKnjiga kupljenaKnjiga);

	public int [] save(ArrayList<KupljenaKnjiga> kupljeneKnjige);
	
	public int update(KupljenaKnjiga kupljenaKnjiga);

	public int delete(int id);
}
