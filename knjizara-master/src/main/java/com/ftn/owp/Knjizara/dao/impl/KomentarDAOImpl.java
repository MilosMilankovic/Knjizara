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
import com.ftn.owp.Knjizara.dao.KomentarDAO;
import com.ftn.owp.Knjizara.dao.KorisnikDAO;
import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Komentar;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.StatusTip;

@Repository
public class KomentarDAOImpl implements KomentarDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private KorisnikDAO korisnikDAO;
	
	@Autowired
	private KnjigaDAO knjigaDAO;
	
	private class KomentarRowMapper implements RowMapper<Komentar>{
		
		@Override
		public Komentar mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt(1);
			String tekst = rs.getString(2);
			int ocena = rs.getInt(3);
			Date datum = rs.getDate(4);
			int korisnikId = rs.getInt(5);
			int knjigaId = rs.getInt(6);
			StatusTip status = StatusTip.valueOf(rs.getString(7));
			
			Korisnik korisnik = korisnikDAO.findOne(korisnikId);
			Knjiga knjiga = knjigaDAO.findOne(knjigaId);
			
			
			Komentar komentar = new Komentar(id ,tekst, ocena, datum, korisnik, knjiga, status);
			return komentar;
				

			
		}
	}

	@Override
	public Komentar findOne(int id) {
		try {
			String sql = "SELECT * FROM komentar WHERE id = ?";
			return jdbcTemplate.queryForObject(sql, new KomentarRowMapper(), id);
		} catch (EmptyResultDataAccessException ex) {
			// ako knjiga nije pronađena
			return null;
		}
	}
	@Override
	public List<Komentar> findByKnjigaId(int id){
		try {
			String sql = "SELECT * FROM komentar WHERE Knjiga_id = ? AND status = 'ODOBREN'";
			return jdbcTemplate.query(sql, new KomentarRowMapper(), id);
		} catch (EmptyResultDataAccessException ex) {
			// ako korisnik nije pronađen
			return null;
		}
	}

	@Override
	public List<Komentar> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Komentar> find(String naziv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Komentar komentar) {
		String sql = "INSERT INTO komentar (tekst, ocena, datum, Korisnik_id, Knjiga_id, status) VALUES (?,?, NOW(),?, ?,?)";
		jdbcTemplate.update(sql, komentar.getTekst(), komentar.getOcena(), komentar.getAutor().getId(), komentar.getKnjiga().getId(), komentar.getStatus().toString());
	}

	@Override
	public int[] save(ArrayList<Komentar> komentari) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Komentar komentar) {
		// TODO Auto-generated method stub
		String sql = "UPDATE komentar SET status = ? WHERE id = ?";
		jdbcTemplate.update(sql, komentar.getStatus().toString(), komentar.getId());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Komentar> findByKorisnikId(int id) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM komentar WHERE Korisnik_id = ?";
			return jdbcTemplate.query(sql, new KomentarRowMapper(), id);
		} catch (EmptyResultDataAccessException ex) {
			// ako korisnik nije pronađen
			return null;
		}
	}
	@Override
	public List<Komentar> findByStatus(StatusTip status) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM komentar WHERE status = ?";
			return jdbcTemplate.query(sql, new KomentarRowMapper(), status.toString());
		} catch (EmptyResultDataAccessException ex) {
			// ako korisnik nije pronađen
			return null;
		}
	}

}
