package com.ftn.owp.Knjizara.service;

import java.util.Date;
import java.util.List;

import com.ftn.owp.Knjizara.model.SpecijalniDatum;

public interface SpecijalniDatumService {
	public List<SpecijalniDatum> findAll();
	public void save(SpecijalniDatum specijalniDatum);
	boolean jesteSpecijalan(Date date);



}
