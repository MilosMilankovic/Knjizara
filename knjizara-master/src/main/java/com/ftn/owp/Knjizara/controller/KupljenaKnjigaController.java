package com.ftn.owp.Knjizara.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.KupljenaKnjiga;
import com.ftn.owp.Knjizara.service.KnjigaService;
import com.ftn.owp.Knjizara.service.KupljenaKnjigaService;

@Controller
@RequestMapping("/kupovina-admin")
public class KupljenaKnjigaController {
	
	@Autowired
	KupljenaKnjigaService kupljenaKnjigaService;
	@Autowired 
	KnjigaService knjigaService;
	
	@Autowired
	private ServletContext servletContext;

	
	
	@PostMapping("")
	public void postKupovinaAdmin(@RequestParam int brojPrimeraka, @RequestParam int knjigaId, HttpServletResponse response ) throws IOException {
		Knjiga knjiga = knjigaService.findOne(knjigaId);
		KupljenaKnjiga kupljenaKnjiga = new KupljenaKnjiga(knjiga, brojPrimeraka, brojPrimeraka*knjiga.getCena());
		kupljenaKnjigaService.save(kupljenaKnjiga);
		response.sendRedirect(servletContext.getContextPath()+"/knjiga/"+knjigaId+"?poruka=Knjiga uspesno kupljena!");
		return;

		
		
		
		
	}

}
