package com.ftn.owp.Knjizara.service;

import javax.servlet.http.HttpSession;

import com.ftn.owp.Knjizara.model.KnjigaIKolicina;
import com.ftn.owp.Knjizara.model.Korpa;

public interface KorpaService {
	
	public void add(KnjigaIKolicina knjigaIKolicina, HttpSession session);
	public void remove(int id, HttpSession session);
	public Korpa findAll(HttpSession session);
	
	void ocisti(HttpSession session);
	
	
	

	
	
}
