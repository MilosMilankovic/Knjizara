package com.ftn.owp.Knjizara.service;

import java.util.List;

import com.ftn.owp.Knjizara.model.KupljenaKnjiga;

public interface KupljenaKnjigaService {
	KupljenaKnjiga findOne(Long id);
	List<KupljenaKnjiga> findAll();
	void save(KupljenaKnjiga kupljenaKnjiga);
	KupljenaKnjiga update(KupljenaKnjiga kupljenaKnjiga);
	KupljenaKnjiga delete(Long id);

}
