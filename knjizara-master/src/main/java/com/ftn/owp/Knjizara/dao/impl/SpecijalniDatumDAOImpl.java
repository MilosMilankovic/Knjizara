package com.ftn.owp.Knjizara.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ftn.owp.Knjizara.dao.SpecijalniDatumDAO;
import com.ftn.owp.Knjizara.model.SpecijalniDatum;

@Repository
public class SpecijalniDatumDAOImpl implements SpecijalniDatumDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private class SpecijalniDatumRowMapper implements RowMapper<SpecijalniDatum>{
		
		@Override
		public SpecijalniDatum mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt(1);
			Date datum = rs.getDate(2);
			int popust = rs.getInt(3);
			
			SpecijalniDatum specijalniDatum = new SpecijalniDatum(id, datum, popust);
			return specijalniDatum;
		}
		
	
		
		
	}
	@Override
	public List<SpecijalniDatum> findAll() {
		String sql = "SELECT * FROM specijalnidatum";
		return jdbcTemplate.query(sql, new SpecijalniDatumRowMapper());
	}
	
	@Override
	public void save(SpecijalniDatum specijalniDatum) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO specijalnidatum (datum, popust) VALUES (?,?)";
		jdbcTemplate.update(sql, specijalniDatum.getDatum(), specijalniDatum.getPopust());
	}


	

}
