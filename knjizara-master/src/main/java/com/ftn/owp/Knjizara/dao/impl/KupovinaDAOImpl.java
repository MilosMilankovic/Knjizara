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

import com.ftn.owp.Knjizara.dao.KnjigaDAO;
import com.ftn.owp.Knjizara.dao.KorisnikDAO;
import com.ftn.owp.Knjizara.dao.KupovinaDAO;
import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.Kupovina;

@Repository
public class KupovinaDAOImpl implements KupovinaDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private KnjigaDAO knjigaDAO;
	
	@Autowired
	private KorisnikDAO korisnikDAO;
	private class KupovinaRowMapper implements RowMapper<Kupovina> {

		@Override
		public Kupovina mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt(1);
			int idKnjiga = rs.getInt(2);
			Knjiga knjiga = knjigaDAO.findOne(idKnjiga);
			double cena = rs.getDouble(3);
			Date datum = rs.getDate(4);
			int idKorisnik = rs.getInt(5);
			Korisnik korisnik = korisnikDAO.findOne(idKorisnik);
			
			Kupovina kupovina = new Kupovina(id, knjiga, cena, datum, korisnik);
			return kupovina;

			
		}

	}


	@Override
	public Kupovina findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kupovina> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kupovina> find(String naziv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Kupovina kupovina) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO kupovina ( Knjiga_id, cena, datum, Korisnik_id) VALUES (?,?, NOW(), ?)";
		jdbcTemplate.update(sql, kupovina.getKnjiga().getId(), kupovina.getCena(), kupovina.getKorisnik().getId());
	}

	@Override
	public int[] save(ArrayList<Kupovina> kupovine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Kupovina kupovina) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Kupovina> find(Korisnik korisnik) {
		try {
			String sql = "SELECT * FROM kupovina WHERE Korisnik_id = ?";
			return jdbcTemplate.query(sql, new KupovinaRowMapper(), korisnik.getId());
		} catch (EmptyResultDataAccessException ex) {
			// ako knjiga nije pronađena
			return null;
		}
	}
	
	@Override
	public List<Kupovina> find(Knjiga knjiga){
		
		try {
			String sql = "SELECT * FROM kupovina WHERE Knjiga_id = ?";
			return jdbcTemplate.query(sql, new KupovinaRowMapper(), knjiga.getId());
		} catch (EmptyResultDataAccessException ex) {
			// ako knjiga nije pronađena
			return null;
		}
		
		
	}

}
