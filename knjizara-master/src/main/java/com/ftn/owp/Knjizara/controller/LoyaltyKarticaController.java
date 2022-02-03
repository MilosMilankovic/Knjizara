package com.ftn.owp.Knjizara.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.LoyaltyKartica;
import com.ftn.owp.Knjizara.model.StatusTip;
import com.ftn.owp.Knjizara.service.LoyaltyKarticaService;

@Controller
@RequestMapping("/loyaltykartica")
public class LoyaltyKarticaController {
	
	
	@Autowired
	LoyaltyKarticaService loyaltyKarticaService;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("")
	public ModelAndView getLoyaltyKartica() {
		List<LoyaltyKartica> kartice = loyaltyKarticaService.findAll();
		
		for(LoyaltyKartica kartica : kartice) {
			System.out.println(kartica.getBrojPoena() + " " + kartica.getKorisnik().getKorisnickoIme());
		}
		ModelAndView loyaltyKarticeView = new ModelAndView("loyalty_kartice.html");
		loyaltyKarticeView.addObject("kartice", kartice);
		return loyaltyKarticeView;
	}
	
	@RequestMapping("/odobri/{id}")
	public void postOdobri(HttpServletResponse response, @PathVariable int id) throws IOException {
		loyaltyKarticaService.promeniStatus(id, StatusTip.ODOBREN);
		response.sendRedirect(servletContext.getContextPath()+"/loyaltykartica");

	}
	@RequestMapping("/odbij/{id}")
	public void postOdbij(HttpServletResponse response, @PathVariable int id) throws IOException {
		loyaltyKarticaService.promeniStatus(id, StatusTip.NIJE_ODOBREN);
		response.sendRedirect(servletContext.getContextPath()+"/loyaltykartica");

	}
	@RequestMapping("/zahtev")
	public ModelAndView getPosaljiZahtev(HttpSession session) {
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute(KorisnikController.KORISNIK_KEY);
		ModelAndView view = new ModelAndView("zahtev_kartica.html");

		boolean odobren = loyaltyKarticaService.odobrenZahtev(prijavljeniKorisnik);
		if(odobren) {
			view.addObject("poruka", "Vaš zahtev je odobren");
		}
		
		
		boolean podnesen = loyaltyKarticaService.podnesenZahtev(prijavljeniKorisnik);
		if(podnesen) {
			view.addObject("poruka", "Već ste podneli zahtev");
		}
		view.addObject("podnesen", podnesen);
		view.addObject("odobren", odobren);
		return view;
		
	}
	@PostMapping("/zahtev")
	public void postPosaljiZahtev(HttpServletResponse response, HttpSession session) throws IOException {
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute(KorisnikController.KORISNIK_KEY);

		
		LoyaltyKartica kartica = new LoyaltyKartica(0,0,prijavljeniKorisnik, StatusTip.CEKANJE);
		
		loyaltyKarticaService.save(kartica);
		response.sendRedirect(servletContext.getContextPath()+"/knjiga");

	}
	
	
	
	

}
