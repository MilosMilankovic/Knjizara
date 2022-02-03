package com.ftn.owp.Knjizara.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.KnjigaIKolicina;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.Korpa;
import com.ftn.owp.Knjizara.model.LoyaltyKartica;
import com.ftn.owp.Knjizara.service.KnjigaService;
import com.ftn.owp.Knjizara.service.KorpaService;
import com.ftn.owp.Knjizara.service.LoyaltyKarticaService;

@Controller
@RequestMapping("/korpa")
public class KorpaController {
	@Autowired
	KorpaService korpaService;
	@Autowired
	KnjigaService knjigaService;
	
	@Autowired
	LoyaltyKarticaService loyaltyKarticaService;
	
	@Autowired
	private ServletContext servletContext;

	
	@RequestMapping("")
	public ModelAndView getAllKorpa(HttpSession session) {
		ModelAndView knjigeView = new ModelAndView("korpa");
		//privremeno za test
		List<Knjiga> knjige = new ArrayList<Knjiga>();
		Korpa korpa  =  korpaService.findAll(session);
		for ( KnjigaIKolicina knjigaIKolicina : korpa.getKnjigeIKolicine()) {
			knjige.add(knjigaIKolicina.getKnjiga());
		}
		String knjigePodaci = "";
		String kolicinePodaci = "";
		for ( KnjigaIKolicina knjigaIKolicina : korpa.getKnjigeIKolicine()) {
			knjigePodaci +=  knjigaIKolicina.getKnjiga().getId() + " ";
			kolicinePodaci += knjigaIKolicina.getKolicina() + " ";
			
			
		}
		
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute(KorisnikController.KORISNIK_KEY);

		
		
		LoyaltyKartica loyaltyKartica = loyaltyKarticaService.findByKorisnikId(prijavljeniKorisnik.getId());
		knjigeView.addObject("knjige", knjige);
		knjigeView.addObject("korpa", korpa);
		knjigeView.addObject("knjigePodaci", knjigePodaci);
		knjigeView.addObject("kolicinePodaci", kolicinePodaci);
		List<Integer> ponudjeniBodovi = new ArrayList<Integer>();

		if(loyaltyKartica != null) {
			int bodovi = loyaltyKartica.getBrojPoena();
			
			int maksimum = bodovi <= 10 ? bodovi : 10;
			for(int i=0; i<=maksimum; i++) {
				ponudjeniBodovi.add(i);
			}
			
			knjigeView.addObject("bodovi", bodovi);
		}
		else {

			knjigeView.addObject("bodovi", 0);
			
		}
		knjigeView.addObject("ponudjeniBodovi", ponudjeniBodovi);

		
		return knjigeView;	
	}
	
	@RequestMapping("/dodaj")
	public void getDodaj(@RequestParam int knjigaId, @RequestParam int kolicina, HttpSession session, HttpServletResponse response) throws IOException {
		Knjiga knjiga = knjigaService.findOne(knjigaId);
		KnjigaIKolicina knjigaIKolicina = new KnjigaIKolicina(knjiga, kolicina);
		korpaService.add(knjigaIKolicina, session);
		response.sendRedirect(servletContext.getContextPath()+"/korpa");
		
		
	}
	@RequestMapping("/ukloni/{id}")
	public void getObrisi(@PathVariable int id, HttpSession session, HttpServletResponse response) throws IOException {
		korpaService.remove(id, session);
		response.sendRedirect(servletContext.getContextPath()+"/korpa");

	}

}
