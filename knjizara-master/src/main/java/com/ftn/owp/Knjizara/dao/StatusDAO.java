package com.ftn.owp.Knjizara.dao;

import java.util.ArrayList;
import java.util.List;

import com.ftn.owp.Knjizara.model.Status;

public interface StatusDAO {
	public Status findOne(int id);

	public List<Status> findAll();

	public List<Status> find(String naziv);
	
	public int save(Status status);

	public int [] save(ArrayList<Status> statusi);
	
	public int update(Status status);

	public int delete(int id);

}
