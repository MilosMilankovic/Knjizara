package com.ftn.owp.Knjizara.dao;

import java.util.List;

import com.ftn.owp.Knjizara.model.SpecijalniDatum;

public interface SpecijalniDatumDAO {
	List<SpecijalniDatum> findAll();

	void save(SpecijalniDatum specijalniDatum);


}
