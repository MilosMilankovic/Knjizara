package com.ftn.owp.Knjizara.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ftn.owp.Knjizara.dao.ZanrDAO;
import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.TipPismo;
import com.ftn.owp.Knjizara.model.TipPovez;
import com.ftn.owp.Knjizara.model.Zanr;

@Repository
public class ZanrDAOImpl implements ZanrDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private class ZanrRowMapper implements RowMapper<Zanr> {

		@Override
		public Zanr mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt(1);
			String ime = rs.getString(2);
			String opis = rs.getString(3);
			
			Zanr zanr = new Zanr(id, ime, opis);
			return zanr;

			
		}

	}


	@Override
	public Zanr findOne(int id) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM zanr WHERE id = ?";
			return jdbcTemplate.queryForObject(sql, new ZanrRowMapper(), id);
		} catch (EmptyResultDataAccessException ex) {
			// ako korisnik nije pronađen
			return null;
		}
	}

	@Override
	public List<Zanr> findAll() {
		String sql = "SELECT * FROM zanr";
		return jdbcTemplate.query(sql, new ZanrRowMapper());
	}

	@Override
	public List<Zanr> find(String naziv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Zanr zanr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] save(ArrayList<Zanr> zanrovi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Zanr zanr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
