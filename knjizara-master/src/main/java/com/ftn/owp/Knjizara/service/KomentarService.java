package com.ftn.owp.Knjizara.service;

import java.util.List;

import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Komentar;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.StatusTip;


public interface KomentarService {
	Komentar findOne(int id);
	List<Komentar> findAll();
	List<Komentar> findByKnjigaId(int id);
	List<Komentar> findByKorisnikId(int id);
	
	List<Komentar> findByStatus(StatusTip status);
	void save(Komentar komentar);
	void update(Komentar komentar);
	
	

	Komentar delete(int id);
	boolean postavioKomentar(Korisnik korisnik, List<Komentar> komentari);
	
	void promeniStatus(Komentar komentar, StatusTip status);
	

}
