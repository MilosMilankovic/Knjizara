package com.ftn.owp.Knjizara.controller;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Komentar;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.StatusTip;
import com.ftn.owp.Knjizara.service.KnjigaService;
import com.ftn.owp.Knjizara.service.KomentarService;
import com.ftn.owp.Knjizara.service.KorisnikService;
@Controller
public class KomentarController {
	
	@Autowired
	KomentarService komentarService;
	
	@Autowired
	KnjigaService knjigaService;
	
	@Autowired
	KorisnikService korisnikService;
	
	@Autowired
	ServletContext servletContext;
	
	
	
	@PostMapping("komentar")
	public void postKomentar(@RequestParam String tekst, @RequestParam int ocena, @RequestParam String korisnickoIme,
			@RequestParam int knjigaId, HttpServletResponse response) throws IOException {
		
		Korisnik korisnik = korisnikService.findOne(korisnickoIme);
		Knjiga knjiga = knjigaService.findOne(knjigaId);
		Date datum = new Date();
		Komentar komentar = new Komentar(tekst, ocena, datum, korisnik, knjiga, StatusTip.CEKANJE);
		komentarService.save(komentar);
		System.out.println(komentar.getTekst());
		response.sendRedirect(servletContext.getContextPath()+"/knjiga/"+knjiga.getId());

		
		
	}
	@GetMapping("/komentar/odobravanje")
	public ModelAndView getKomentarOdobravanje() {
		List<Komentar> komentari = komentarService.findByStatus(StatusTip.CEKANJE);
		ModelAndView komentariView = new ModelAndView("komentari_odobri.html");
		komentariView.addObject("komentari", komentari);
		return komentariView;
		
	}
	@PostMapping("/komentar/odobri")
	public void postKomentarOdobri(@RequestParam int komentarId, HttpServletResponse response) throws IOException {
		Komentar komentar = komentarService.findOne(komentarId);
		System.out.println(komentar.getTekst());
		komentar.setStatus(StatusTip.ODOBREN);
		komentarService.update(komentar);
		System.out.println("odobravanje");
		response.sendRedirect(servletContext.getContextPath()+"/komentar/odobravanje");
		

		
		
	}
	@PostMapping("/komentar/odbij")
	public void postKomentarOdbij(@RequestParam int komentarId, HttpServletResponse response) throws IOException {
		Komentar komentar = komentarService.findOne(komentarId);
		komentar.setStatus(StatusTip.NIJE_ODOBREN);
		komentarService.update(komentar);
		response.sendRedirect(servletContext.getContextPath()+"/komentar/odobravanje");
		
	}
	
}
