package com.ftn.owp.Knjizara.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ftn.owp.Knjizara.model.Izvestaj;
import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Kupovina;
import com.ftn.owp.Knjizara.service.KnjigaService;
import com.ftn.owp.Knjizara.service.KupovinaService;

@Controller
@RequestMapping("/izvestavanje")
public class IzvestavanjeController {
	
	@Autowired
	KnjigaService knjigaService;
	
	
	
	
	@Autowired
	KupovinaService kupovinaService;
	
	@RequestMapping("")
	public ModelAndView getIzvestavanje() {
		ModelAndView izvestavanje = new ModelAndView("izvestavanje");
		List<Knjiga> knjige = knjigaService.findAll();
		List<Izvestaj> izvestaji = new ArrayList<Izvestaj>();
		for(Knjiga knjiga : knjige) {
			List<Kupovina> kupovine = kupovinaService.find(knjiga);
			izvestaji.add(new Izvestaj(knjiga, kupovine.size()));
		}
		izvestavanje.addObject("izvestaji", izvestaji);
		return izvestavanje;
	}

}
