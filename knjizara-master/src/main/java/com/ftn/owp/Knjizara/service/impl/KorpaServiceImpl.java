package com.ftn.owp.Knjizara.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.owp.Knjizara.dao.KnjigaDAO;
import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.KnjigaIKolicina;
import com.ftn.owp.Knjizara.model.Korpa;
import com.ftn.owp.Knjizara.service.KorpaService;

@Service
public class KorpaServiceImpl implements KorpaService {
	@Autowired
	KnjigaDAO knjigaDAO;
	
	

	@Override
	public void add(KnjigaIKolicina knjigaIKolicina, HttpSession session) {
		// TODO Auto-generated method stub
		Korpa korpa = (Korpa) session.getAttribute("korpa");
		if( korpa == null) {
			korpa = new Korpa();
		}
		korpa.dodaj(knjigaIKolicina);
		session.setAttribute("korpa", korpa); 
		

		
	}

	@Override
	public void remove(int id, HttpSession session) {
		Korpa korpa = (Korpa) session.getAttribute("korpa");
		korpa.ukloni(id);
		session.setAttribute("korpa", korpa); 
	}

	@Override
	public Korpa findAll(HttpSession session) {
		// TODO Auto-generated method stub
		Korpa korpa = (Korpa) session.getAttribute("korpa");
		if( korpa == null) {
			korpa = new Korpa();
		}
		return korpa;
		
	}
	@Override
	public void ocisti(HttpSession session) {
		session.setAttribute("korpa", null);
	}
	
	

}
