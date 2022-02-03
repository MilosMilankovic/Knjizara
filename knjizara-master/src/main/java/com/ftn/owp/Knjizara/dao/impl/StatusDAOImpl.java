package com.ftn.owp.Knjizara.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ftn.owp.Knjizara.dao.StatusDAO;
import com.ftn.owp.Knjizara.model.Status;

@Repository
public class StatusDAOImpl implements StatusDAO {

	@Override
	public Status findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Status> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Status> find(String naziv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Status status) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] save(ArrayList<Status> statusi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Status status) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
