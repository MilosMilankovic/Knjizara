package com.ftn.owp.Knjizara.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.Kupovina;
import com.ftn.owp.Knjizara.service.KorisnikService;
import com.ftn.owp.Knjizara.service.KupovinaService;

@Controller
public class KorisnikController {
	public static final String KORISNIK_KEY = "prijavljeniKorisnik";
	@Autowired
	private ServletContext servletContext;

	@Autowired
	KorisnikService korisnikService;

	@Autowired
	KupovinaService kupovinaService;

	@GetMapping("")
	public void getIndex(HttpServletResponse response) throws IOException {
		response.sendRedirect(servletContext.getContextPath() + "/prijava");

	}

	@GetMapping("/prijava")
	public String getLogin() {
		return "prijava";
	}

	@GetMapping("/registracija")
	public String getRegister() {
		return "registracija";
	}

	@PostMapping("/prijava")
	public ModelAndView postLogin(@RequestParam String korisnickoIme, @RequestParam String lozinka, HttpSession session,
			HttpServletResponse response) throws IOException {
		ModelAndView greska = new ModelAndView("prijava");
		Korisnik korisnik = korisnikService.findOne(korisnickoIme, lozinka);
		if (korisnik == null) {
			greska.addObject("poruka", "Pogresno korisnicko ime ili lozinka");
			return greska;
		}
		if(korisnik.isBlokiran()) {
			greska.addObject("poruka", "Pristup ovom sajtu je vam blokiran");
			return greska;
		}

		session.setAttribute(KorisnikController.KORISNIK_KEY, korisnik);
		response.sendRedirect(servletContext.getContextPath() + "/knjiga");
		return null;
	}

	@PostMapping("/registracija")
	public void postRegister(@RequestParam String korisnickoIme, @RequestParam String lozinka,
			@RequestParam String email, @RequestParam String ime, @RequestParam String prezime,
			@RequestParam String datumRodjenjaString, @RequestParam String adresa, @RequestParam String brojTelefona,
			HttpServletResponse response) throws ParseException, IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date datumRodjenja = formatter.parse(datumRodjenjaString);
		Korisnik korisnik = new Korisnik(korisnickoIme, lozinka, email, ime, prezime, datumRodjenja, adresa,
				brojTelefona, false);
		korisnikService.save(korisnik);
		response.sendRedirect(servletContext.getContextPath() + "/prijava");
		return;
	}

	@GetMapping("/korisnik/{korisnickoIme}")
	public ModelAndView getOneKorisnik(HttpSession session, @PathVariable String korisnickoIme) {
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute(KorisnikController.KORISNIK_KEY);
		
		

		
		
		
		List<Knjiga> knjige = (List<Knjiga>) session.getAttribute("lista_zelja");

		Korisnik korisnik = korisnikService.findOne(korisnickoIme);
		
		List<Korisnik> blokirani = (List<Korisnik>) session.getAttribute("blokirani");
	
		
		
		List<Kupovina> kupovine = kupovinaService.find(korisnik);
		ModelAndView profil = new ModelAndView("korisnik");
		profil.addObject("korisnik", korisnik);
		profil.addObject("prijavljeniKorisnik", prijavljeniKorisnik);
		profil.addObject("kupovine", kupovine);
		profil.addObject("knjige", knjige);
		return profil;
	}

	@GetMapping("/odjava")
	public void getOdjava(HttpSession session, HttpServletResponse response) throws IOException {
		session.setAttribute(KorisnikController.KORISNIK_KEY, null);
		response.sendRedirect(servletContext.getContextPath() + "/prijava");

	}

}
