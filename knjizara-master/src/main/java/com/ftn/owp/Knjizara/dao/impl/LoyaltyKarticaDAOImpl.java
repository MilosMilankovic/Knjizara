package com.ftn.owp.Knjizara.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ftn.owp.Knjizara.dao.KorisnikDAO;
import com.ftn.owp.Knjizara.dao.LoyaltyKarticaDAO;
import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.LoyaltyKartica;
import com.ftn.owp.Knjizara.model.StatusTip;

@Repository
public class LoyaltyKarticaDAOImpl implements LoyaltyKarticaDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private KorisnikDAO korisnikDAO;
	
	private class LoyaltyKarticaRowMapper implements RowMapper<LoyaltyKartica> {

		@Override
		public LoyaltyKartica mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt(1);
			double popust = rs.getDouble(2);
			int poeni = rs.getInt(3);
			String statusString = rs.getString(4);
			StatusTip status = StatusTip.valueOf(statusString);
			int korisnikId = rs.getInt(5);
			Korisnik korisnik = korisnikDAO.findOne(korisnikId);
		
			LoyaltyKartica loyaltyKartica = new LoyaltyKartica(id, popust, poeni, korisnik, status);
			return loyaltyKartica;
		}

	}

	@Override
	public LoyaltyKartica findOne(int id) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM loyaltykartica WHERE id = ?";
			return jdbcTemplate.queryForObject(sql, new LoyaltyKarticaRowMapper(), id);
		} catch (EmptyResultDataAccessException ex) {
			// ako knjiga nije pronađena
			return null;
		}
	}

	

	@Override
	public LoyaltyKartica findByKorisnikId(int korisnikId) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM loyaltykartica WHERE Korisnik_id = ?";
			return jdbcTemplate.queryForObject(sql, new LoyaltyKarticaRowMapper(), korisnikId);
		} catch (EmptyResultDataAccessException ex) {
			// ako knjiga nije pronađena
			return null;
		}
	}
	@Override
	public List<LoyaltyKartica> findAll() {
		String sql = "SELECT * FROM loyaltykartica WHERE status = 'CEKANJE'";
		return jdbcTemplate.query(sql, new LoyaltyKarticaRowMapper());
	}

	@Override
	public List<LoyaltyKartica> find(String naziv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(LoyaltyKartica loyaltyKartica) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO loyaltykartica (popust, poeni, status, korisnik_id) VALUES (?, ?,?,?)";
		jdbcTemplate.update(sql, loyaltyKartica.getPopust(), loyaltyKartica.getBrojPoena(), loyaltyKartica.getStatus().toString(), loyaltyKartica.getKorisnik().getId());
	}

	@Override
	public int[] save(ArrayList<LoyaltyKartica> loyaltyKartice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(LoyaltyKartica loyaltyKartica) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void promeniStatus(int id, StatusTip odobren) {
		String sql = "UPDATE loyaltykartica SET status = ?, popust=20, poeni=4 WHERE id=?";
		jdbcTemplate.update(sql, odobren.toString(), id);
		// TODO Auto-generated method stub		
	}

	@Override
	public boolean odobrenZahtev(Korisnik prijavljeniKorisnik) {
		// TODO Auto-generated method stub
				try {
					String sql = "SELECT * FROM loyaltykartica WHERE Korisnik_id = ? AND status = 'ODOBREN'";
					if (jdbcTemplate.queryForObject(sql, new LoyaltyKarticaRowMapper(), prijavljeniKorisnik.getId()) != null){
						return true;
					}
					return false;
				} catch (EmptyResultDataAccessException ex) {
					// ako knjiga nije pronađena
					return false;
				}
	}

	@Override
	public void dodajBrojPoena(int poeni, int id) {
		String sql = "UPDATE loyaltykartica SET poeni=poeni + ? WHERE Korisnik_id=? AND status='ODOBREN'";
		jdbcTemplate.update(sql, poeni, id);
		
	}

	@Override
	public boolean podnesenZahtev(Korisnik prijavljeniKorisnik) {
		try {
			String sql = "SELECT * FROM loyaltykartica WHERE Korisnik_id = ? AND status = 'CEKANJE'";
			if (jdbcTemplate.queryForObject(sql, new LoyaltyKarticaRowMapper(), prijavljeniKorisnik.getId()) != null){
				return true;
			}
			return false;
		} catch (EmptyResultDataAccessException ex) {
			// ako knjiga nije pronađena
			return false;
		}
	}

}
