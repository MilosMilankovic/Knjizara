package com.ftn.owp.Knjizara.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Komentar;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.TipPismo;
import com.ftn.owp.Knjizara.model.TipPovez;
import com.ftn.owp.Knjizara.model.Uloga;
import com.ftn.owp.Knjizara.model.Zanr;
import com.ftn.owp.Knjizara.service.KnjigaService;
import com.ftn.owp.Knjizara.service.KomentarService;
import com.ftn.owp.Knjizara.service.KorisnikService;
import com.ftn.owp.Knjizara.service.ZanrService;

@Controller
@RequestMapping("/knjiga")
public class KnjigaController {
	
	@Autowired
	KnjigaService knjigaService;
	
	@Autowired
	KomentarService komentarService;
	
	@Autowired
	KorisnikService korisnikService;
	
	@Autowired
	ZanrService zanrService;
	
	@Autowired
	ServletContext servletContext;
	
	 @Autowired
	 HttpServletRequest request;

	
	
	@RequestMapping("")
	public ModelAndView getAllKnjiga(HttpSession session, HttpServletResponse response) throws IOException {
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute(KorisnikController.KORISNIK_KEY);
		if(prijavljeniKorisnik == null) {
			response.sendRedirect(servletContext.getContextPath()+"/prijava");
			return new ModelAndView("prijava");

		}


		List<Knjiga> knjige = knjigaService.findAll();
		
		for(Knjiga knjiga : knjige) {
			List<Komentar> komentariZaKnjigu = komentarService.findByKnjigaId(knjiga.getId());
			int zbirOcena = 0;
			double prosecnaOcena = 0;
			for (Komentar komentar : komentariZaKnjigu) {
				zbirOcena += komentar.getOcena();
			}try {
				prosecnaOcena = (double)zbirOcena / komentariZaKnjigu.size();
				knjiga.setProsecnaOcena(prosecnaOcena);


				
			}
			catch(Exception exc) {
				knjiga.setProsecnaOcena(0);
			}
		}
		
		
		List<Zanr> zanrovi = zanrService.findAll();
		ModelAndView knjigeView = new ModelAndView("lista_knjiga");
		knjigeView.addObject("knjige", knjige);
		knjigeView.addObject("zanrovi", zanrovi);
		knjigeView.addObject("korisnik", prijavljeniKorisnik);

		return knjigeView;
	}
	@RequestMapping("/{id}")
	public ModelAndView getOneKnjiga(@PathVariable int id, HttpSession session, @RequestParam(required=false) String poruka, HttpServletResponse response) throws IOException {
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute(KorisnikController.KORISNIK_KEY);
		if(prijavljeniKorisnik == null) {
			response.sendRedirect(servletContext.getContextPath()+"/knjiga");

		}
		Knjiga knjiga = knjigaService.findOne(id);
		
		List<Komentar> komentari = komentarService.findByKnjigaId(id);
		
		List<Komentar> komentariZaKnjigu = komentarService.findByKnjigaId(knjiga.getId());
		int zbirOcena = 0;
		double prosecnaOcena = 0;
		for (Komentar komentar : komentariZaKnjigu) {
			zbirOcena += komentar.getOcena();
		}try {
			prosecnaOcena = (double)zbirOcena / komentariZaKnjigu.size();
			knjiga.setProsecnaOcena(prosecnaOcena);


			
		}
		catch(Exception exc) {
			knjiga.setProsecnaOcena(0);
		}
		
		
		
		
		
		boolean kupioKnjigu = korisnikService.kupioKnjigu(prijavljeniKorisnik, knjiga);
		
		ModelAndView knjigaView = new ModelAndView("knjiga");
		
		boolean nijePostavioKomentar = !komentarService.postavioKomentar(prijavljeniKorisnik, komentari);
		
		
	
		
		knjigaView.addObject("knjiga", knjiga);
		knjigaView.addObject("komentari", komentari);
		knjigaView.addObject("korisnik", prijavljeniKorisnik);
		knjigaView.addObject("poruka", poruka);
		knjigaView.addObject("kupioKnjigu", kupioKnjigu);
		knjigaView.addObject("nijePostavioKomentar", nijePostavioKomentar);
		return knjigaView;
	}
	
	@RequestMapping("/pretraga")
	public ModelAndView getPretragaKnjiga(HttpServletResponse response, HttpSession session, @RequestParam(required=false) String autor,
			@RequestParam(required=false) String naziv, @RequestParam(required=false, defaultValue="0") double minCena,
			@RequestParam(required=false, defaultValue="100000") double maxCena, @RequestParam(required=false) String jezik ) throws IOException {
		
		System.out.println(minCena);
		System.out.println(autor);
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute(KorisnikController.KORISNIK_KEY);
		if(prijavljeniKorisnik == null) {
			response.sendRedirect(servletContext.getContextPath()+"/knjiga");

		}
		ModelAndView knjigeView = new ModelAndView("lista_knjiga");
		knjigeView.addObject("korisnik", prijavljeniKorisnik);
		
		//Zanr zanr = zanrService.findOne(idZanr);
		
		List<Knjiga> knjige = knjigaService.find(naziv.trim(), null,minCena, maxCena, autor.trim(), jezik.trim() );
		List<Zanr> zanrovi = zanrService.findAll();
		
		for(Knjiga knjiga : knjige) {
			List<Komentar> komentariZaKnjigu = komentarService.findByKnjigaId(knjiga.getId());
			int zbirOcena = 0;
			double prosecnaOcena = 0;
			for (Komentar komentar : komentariZaKnjigu) {
				zbirOcena += komentar.getOcena();
			}try {
				prosecnaOcena = (double)zbirOcena / komentariZaKnjigu.size();
				knjiga.setProsecnaOcena(prosecnaOcena);


				
			}
			catch(Exception exc) {
				knjiga.setProsecnaOcena(0);
			}
		}
		
		
		

		knjigeView.addObject("knjige",knjige);
		knjigeView.addObject("zanrovi", zanrovi);

		return knjigeView;
		
		
	}
	@RequestMapping("/pretraga_po_isbn")
	public ModelAndView getPretragaPoIsbn(HttpServletResponse response, HttpSession session, @RequestParam int ISBN) {
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute(KorisnikController.KORISNIK_KEY);


		ModelAndView view = new ModelAndView("lista_knjiga");
		Knjiga knjiga = knjigaService.findByISBN(ISBN);
		List<Knjiga> knjige = new ArrayList<Knjiga>();
		if( knjiga != null) {
			knjige.add(knjiga);
		}
		
		for(Knjiga knjiga1 : knjige) {
			List<Komentar> komentariZaKnjigu = komentarService.findByKnjigaId(knjiga1.getId());
			int zbirOcena = 0;
			double prosecnaOcena = 0;
			for (Komentar komentar : komentariZaKnjigu) {
				zbirOcena += komentar.getOcena();
			}try {
				prosecnaOcena = (double)zbirOcena / komentariZaKnjigu.size();
				knjiga1.setProsecnaOcena(prosecnaOcena);


				
			}
			catch(Exception exc) {
				knjiga1.setProsecnaOcena(0);
			}
		}
		
		
		view.addObject("knjige", knjige);
	    view.addObject("korisnik", prijavljeniKorisnik);

		return view;
		
	}
	
	
	@RequestMapping("/dodaj")
	public 	ModelAndView getDodajKnjiga(HttpServletResponse response, HttpSession session) throws IOException {
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute(KorisnikController.KORISNIK_KEY);
		System.out.println(request.getServletContext().getRealPath("/"));

		if(prijavljeniKorisnik == null) {
			response.sendRedirect(servletContext.getContextPath()+"/knjiga");

		}
		if(prijavljeniKorisnik.getUloga().equals(Uloga.ADMINISTRATOR)) {
			ModelAndView view = new ModelAndView("dodaj_knjiga.html");
			List<Zanr> zanrovi = zanrService.findAll();
			view.addObject("zanrovi", zanrovi);
			return view;
			
		}
		return null;
		
	}
	
	@PostMapping("/dodaj")
	public void postDodajKnjiga(HttpServletResponse response, @RequestParam String naziv, @RequestParam int isbn, 
			@RequestParam String izdavackaKuca,
			@RequestParam String autor, @RequestParam String godinaIzdavanja,
			@RequestParam String kratakOpis, @RequestParam MultipartFile slika, @RequestParam double cena, @RequestParam int brojStranica,
			@RequestParam String tipPoveza, @RequestParam String pismo, @RequestParam String jezik) throws ParseException, IOException {
		TipPovez povez = TipPovez.valueOf(tipPoveza);
		TipPismo pismoEnum = TipPismo.valueOf(pismo);
		//Date god = new Date(); //pretvoriti u godinu izdavanja
	    Date god=new SimpleDateFormat("yyyy").parse(godinaIzdavanja);  
		Knjiga knjiga = new Knjiga(naziv, isbn, izdavackaKuca, autor, god, kratakOpis, slika.getOriginalFilename(), cena, brojStranica, povez, pismoEnum, jezik);
		
		knjigaService.save(knjiga);
		response.sendRedirect(servletContext.getContextPath()+"/knjiga");
	
		
	
	}
	
	@RequestMapping("/izmeni/{id}")
	public ModelAndView getIzmeniKnjiga(@PathVariable int id) {
		Knjiga knjiga = knjigaService.findOne(id);
		ModelAndView knjigaView = new ModelAndView("izmeni_knjiga");
		knjigaView.addObject("knjiga", knjiga);
		return knjigaView;
		
		
	}
	@PostMapping("/izmeni/{id}")
	public void getIzmeniKnjiga(HttpServletResponse response, @PathVariable int id, @RequestParam String naziv, @RequestParam int isbn,
			@RequestParam String izdavackaKuca,
			@RequestParam String autor, @RequestParam String godinaIzdavanja,
			@RequestParam String kratakOpis,  @RequestParam MultipartFile slika, @RequestParam double cena, @RequestParam int brojStranica, 
			@RequestParam String tipPoveza, @RequestParam String pismo, @RequestParam String jezik) throws ParseException, IOException {
		TipPovez povez = TipPovez.valueOf(tipPoveza);
		TipPismo pismoEnum = TipPismo.valueOf(pismo);
		//Date god = new Date(); //pretvoriti u godinu izdavanja
	    Date god=new SimpleDateFormat("yyyy").parse(godinaIzdavanja); 
		Knjiga knjiga = new Knjiga(id, naziv, isbn, izdavackaKuca, autor, god, kratakOpis, slika.getOriginalFilename(), cena, brojStranica, povez, pismoEnum, jezik);
		knjigaService.update(knjiga);
		response.sendRedirect(servletContext.getContextPath()+"/knjiga/"+id);

	}
	@RequestMapping("/lista_zelja")
	public 	ModelAndView getListaZelja(HttpSession session) {
		List<Knjiga> knjige = (List<Knjiga>) session.getAttribute("lista_zelja");
		if(knjige == null) {
			knjige = new ArrayList<Knjiga>();
		}
		ModelAndView view = new ModelAndView("lista_zelja.html");
		view.addObject("knjige", knjige);
		return view;
		
	}
	@PostMapping("/lista_zelja")
	public void postListaZelja(HttpSession session, HttpServletResponse response, @RequestParam int knjigaId) throws IOException {
		List<Knjiga> knjige = (List<Knjiga>) session.getAttribute("lista_zelja");
		if(knjige == null) {
			knjige = new ArrayList<Knjiga>();
		}
		boolean postoji = false;
		for(Knjiga knjiga : knjige) {
			if(knjiga.getId() == knjigaId) {
				postoji = true;
			}
		}
		if(!postoji) {
			Knjiga knjiga = knjigaService.findOne(knjigaId);
			knjige.add(knjiga);
			session.setAttribute("lista_zelja", knjige); 
		}
		response.sendRedirect(servletContext.getContextPath()+"/knjiga");


	}
	
	@PostMapping("/lista_zelja/ukloni")
	public void getUkloniListaZelja(HttpSession session, HttpServletResponse response, @RequestParam int knjigaId) throws IOException {
		List<Knjiga> knjige = (List<Knjiga>) session.getAttribute("lista_zelja");
		int indeksBrisanje = 0;
		for(Knjiga knjiga : knjige) {
			if(knjiga.getId() == knjigaId) {
				break;
				
			}
			indeksBrisanje++;
		}
		
		if(knjige != null) {
			knjige.remove(indeksBrisanje);
		}
		response.sendRedirect(servletContext.getContextPath()+"/knjiga");

		
		
		
		
	}

}
