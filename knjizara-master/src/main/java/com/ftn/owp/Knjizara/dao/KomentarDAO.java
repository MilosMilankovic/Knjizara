package com.ftn.owp.Knjizara.dao;

import java.util.ArrayList;
import java.util.List;

import com.ftn.owp.Knjizara.model.Komentar;
import com.ftn.owp.Knjizara.model.StatusTip;

public interface KomentarDAO {
	public Komentar findOne(int id);
	
	public List<Komentar> findByKnjigaId(int id);
	
	public List<Komentar> findByKorisnikId(int id);
	public List<Komentar> findByStatus(StatusTip status);


	public List<Komentar> findAll();

	public List<Komentar> find(String naziv);
	
	public void save(Komentar komentar);

	public int [] save(ArrayList<Komentar> komentari);
	
	public void update(Komentar komentar);

	public int delete(int id);

}
