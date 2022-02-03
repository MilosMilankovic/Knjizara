package com.ftn.owp.Knjizara.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.SpecijalniDatum;
import com.ftn.owp.Knjizara.model.Uloga;
import com.ftn.owp.Knjizara.service.KorisnikService;
import com.ftn.owp.Knjizara.service.SpecijalniDatumService;

@Controller
public class AdminController {
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	KorisnikService korisnikService;
	
	
	@Autowired
	SpecijalniDatumService specijalniDatumService;

	
	@RequestMapping("/svi_korisnici")
	public ModelAndView getSviKorisnici() {
		List<Korisnik> korisnici = korisnikService.findAll();
		ModelAndView viewKorisnici = new ModelAndView("svi_korisnici.html");
		viewKorisnici.addObject("korisnici", korisnici);
		return viewKorisnici;
		
	}
	@PostMapping("/promena_uloge")
	public void postPromenaUloge(HttpServletResponse response, @RequestParam String korisnickoIme,  @RequestParam String stringUloga) throws IOException {
		
		System.out.println(korisnickoIme);
		Korisnik korisnik = korisnikService.findOne(korisnickoIme);
		Uloga uloga = Uloga.valueOf(stringUloga);
		
		korisnikService.promeniUlogu(korisnik, uloga);
		response.sendRedirect(servletContext.getContextPath()+"/svi_korisnici");

		
		
	}
	@RequestMapping("/specijalni-datumi")
	public ModelAndView getSpecijalniDatumi(HttpServletResponse response, HttpSession session) {
		System.out.println(specijalniDatumService.jesteSpecijalan(new Date()));

		ModelAndView view = new ModelAndView("specijalni_popusti");
		return view;
		
		
	}
	@PostMapping("/specijalni-datumi")
	public void postSpecijalniDatumi(HttpServletResponse response, @RequestParam int popust, @RequestParam String datum) throws IOException, ParseException {
		
		System.out.println(specijalniDatumService.jesteSpecijalan(new Date()));
		System.out.println(datum);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date praviDatum = formatter.parse(datum);
		System.out.println(praviDatum.getMonth());
		SpecijalniDatum specijalniDatum = new SpecijalniDatum(praviDatum, popust);
		specijalniDatumService.save(specijalniDatum);
		response.sendRedirect(servletContext.getContextPath()+"/specijalni-datumi");
		
		
	}
	@PostMapping("/blokiraj")
	public void postBlokiraj(HttpServletResponse response, HttpSession session, @RequestParam int korisnikId) throws IOException {
		Korisnik korisnik = korisnikService.findOne(korisnikId);
		korisnikService.promeniBlokStatus(korisnik, true);
		response.sendRedirect(servletContext.getContextPath()+"/korisnik/"+korisnik.getKorisnickoIme());
		
	}
	@PostMapping("/deblokiraj")
	public void postDeBlokiraj(HttpServletResponse response, HttpSession session, @RequestParam int korisnikId) throws IOException {
		Korisnik korisnik = korisnikService.findOne(korisnikId);
		korisnikService.promeniBlokStatus(korisnik, false);
		response.sendRedirect(servletContext.getContextPath()+"/korisnik/"+korisnik.getKorisnickoIme());
		
	}

}
