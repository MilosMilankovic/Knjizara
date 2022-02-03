package com.ftn.owp.Knjizara.service;

import java.util.List;

import com.ftn.owp.Knjizara.model.Status;


public interface StatusService {
	Status findOne(Long id);
	List<Status> findAll();
	Status save(Status status);
	Status update(Status status);
	Status delete(Long id);

}
