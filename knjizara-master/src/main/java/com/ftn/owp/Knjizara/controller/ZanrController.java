package com.ftn.owp.Knjizara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ftn.owp.Knjizara.service.KnjigaService;
import com.ftn.owp.Knjizara.service.ZanrService;

@Controller
@RequestMapping("/zanr")
public class ZanrController {
	
	@Autowired
	ZanrService zanrService;
	
	@Autowired
	KnjigaService knjigaService;
	
	
	@RequestMapping("/")
	public ModelAndView getAllZanr() {
		return null;
	}
	@RequestMapping("/{naziv}")
	public ModelAndView getOneZanr() {
		return null;
	}


}
