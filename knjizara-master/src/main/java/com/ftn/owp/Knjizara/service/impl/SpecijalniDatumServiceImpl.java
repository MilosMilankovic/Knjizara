package com.ftn.owp.Knjizara.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.owp.Knjizara.dao.SpecijalniDatumDAO;
import com.ftn.owp.Knjizara.model.SpecijalniDatum;
import com.ftn.owp.Knjizara.service.SpecijalniDatumService;

@Service
public class SpecijalniDatumServiceImpl implements SpecijalniDatumService {
	
	@Autowired
	SpecijalniDatumDAO specijalniDatumDAO;

	@Override
	public List<SpecijalniDatum> findAll() {
		// TODO Auto-generated method stub
		return specijalniDatumDAO.findAll();
	}

	@Override
	public void save(SpecijalniDatum specijalniDatum) {
		specijalniDatumDAO.save(specijalniDatum);
		
	}
	@Override
	public boolean jesteSpecijalan(Date date) {
		List<SpecijalniDatum> datumi = findAll();
		for(SpecijalniDatum datum : datumi){{
			if(datum.getDatum().equals(date)) {
				return true;
			}
			}
		}
		return false;
	}

}
