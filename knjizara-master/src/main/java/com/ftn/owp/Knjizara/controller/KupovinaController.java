package com.ftn.owp.Knjizara.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.Kupovina;
import com.ftn.owp.Knjizara.service.KnjigaService;
import com.ftn.owp.Knjizara.service.KorpaService;
import com.ftn.owp.Knjizara.service.KupovinaService;
import com.ftn.owp.Knjizara.service.LoyaltyKarticaService;

@Controller
public class KupovinaController {
	
	@Autowired
	KupovinaService kupovinaService;
	
	@Autowired
	KnjigaService knjigaService;
	
	@Autowired
	KorpaService korpaService;
	
	@Autowired
	LoyaltyKarticaService loyaltyKarticaService;
	
	@Autowired
	ServletContext servletContext;
	
	
	@PostMapping("/kupovina")
	public ModelAndView postKupovina(HttpServletResponse response, HttpSession session, @RequestParam String knjigePodaci,
			@RequestParam String kolicinePodaci, @RequestParam(required=false) int bodovi) throws IOException {
		String[] knjigeIds = knjigePodaci.trim().split(" ");
		String[] kolicine = kolicinePodaci.trim().split(" ");
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute(KorisnikController.KORISNIK_KEY);
		double ukupnaPotrosnja = 0;

		for(int i=0; i<knjigeIds.length; i++) {
			int kolicina = Integer.parseInt(kolicine[i]);
			int id = Integer.parseInt(knjigeIds[i]);

			for(int j=0; j<kolicina; j++) {
				Knjiga knjiga = knjigaService.findOne(id);
				Kupovina kupovina = new Kupovina(knjiga, knjiga.getCena(), prijavljeniKorisnik);
				kupovinaService.save(kupovina);
				ukupnaPotrosnja += knjiga.getCena();
			}
		}
		double staraCena = ukupnaPotrosnja;
		Double novaCena = null;
		if(bodovi != -1) {
			loyaltyKarticaService.dodajBrojPoena(-bodovi, prijavljeniKorisnik.getId());
			ukupnaPotrosnja = ukupnaPotrosnja -  ukupnaPotrosnja * bodovi * 0.05;
			novaCena = ukupnaPotrosnja;
		}
		int poeni =(int) ukupnaPotrosnja/1000;
		
		
		
		
		loyaltyKarticaService.dodajBrojPoena(poeni, prijavljeniKorisnik.getId());
		
		
		korpaService.ocisti(session);
		ModelAndView view = new ModelAndView("uspesna-kupovina.html");
		view.addObject("staraCena", staraCena);
		view.addObject("novaCena", novaCena);
		return view;
		
	}
	@GetMapping("/uspesna-kupovina")
	public ModelAndView postUspesnaKupovina(HttpServletResponse response, HttpSession session) {
		korpaService.ocisti(session);
		ModelAndView uspesnaKupovinaView = new ModelAndView("uspesna-kupovina.html");
		return uspesnaKupovinaView;
	}

}
