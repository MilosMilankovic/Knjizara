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
import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.TipPismo;
import com.ftn.owp.Knjizara.model.TipPovez;
import com.ftn.owp.Knjizara.model.Uloga;
import com.ftn.owp.Knjizara.model.Zanr;

@Repository
public class KnjigaDAOImpl implements KnjigaDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private class KnjigaRowMapper implements RowMapper<Knjiga> {

		@Override
		public Knjiga mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt(1);
			String naziv = rs.getString(2);
			int isbn = rs.getInt(3);
			String izdavackaKuca = rs.getString(4);
			String autor = rs.getString(5);
			Date godinaIzdavanja = rs.getDate(6);
			String kratakOpis = rs.getString(7);
			String slika = rs.getString(8);
			double cena = rs.getDouble(9);
			int brojStranica = rs.getInt(10);
			TipPovez tipPoveza = TipPovez.valueOf(rs.getString(11));
			TipPismo tipPismo = TipPismo.valueOf(rs.getString(12));
			String jezik = rs.getString(13);
			double prosecnaOcena = rs.getDouble(14);
			

			Knjiga knjiga = new Knjiga(id, naziv, isbn, izdavackaKuca, autor, godinaIzdavanja, kratakOpis, slika, cena, brojStranica,
					tipPoveza, tipPismo, jezik, prosecnaOcena);
			return knjiga;
		}

	}

	@Override
	public Knjiga findOne(int id) {
		try {
			String sql = "SELECT * FROM knjiga WHERE id = ?";
			return jdbcTemplate.queryForObject(sql, new KnjigaRowMapper(), id);
		} catch (EmptyResultDataAccessException ex) {
			// ako knjiga nije pronađena
			return null;
		}
	}

	@Override
	public List<Knjiga> findAll() {
		String sql = "SELECT * FROM knjiga";
		return jdbcTemplate.query(sql, new KnjigaRowMapper());
	}

	@Override
	public List<Knjiga> find(String naziv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Knjiga knjiga) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO knjiga (naziv, isbn, izdavackaKuca, autor, godinaIzdavanja, opis, slika, cena, brojStranica, tipPoveza, pismo, jezik) VALUES (?,?,?, ?,?,?, ?,?,?, ?,?,?)";
		jdbcTemplate.update(sql, knjiga.getNaziv(), knjiga.getIsbn(), knjiga.getIzdavackaKuca(), knjiga.getAutor(), knjiga.getGodinaIzdavanja(), knjiga.getKratakOpis(),
				knjiga.getSlika(), knjiga.getCena(), knjiga.getBrojStranica(), knjiga.getTipPoveza().toString(), knjiga.getPismo().toString(), knjiga.getJezik());
				
	}

	@Override
	public int[] save(ArrayList<Knjiga> knjige) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void update(Knjiga knjiga) {
		String sql = "UPDATE knjiga SET naziv=?, isbn=?, izdavackaKuca=?, autor=?, godinaIzdavanja=?, opis=?, slika=?, cena=?, brojStranica=?, tipPoveza=?, pismo=?, jezik=? WHERE id=?";
		jdbcTemplate.update(sql, knjiga.getNaziv(), knjiga.getIsbn(), knjiga.getIzdavackaKuca(), knjiga.getAutor(), knjiga.getGodinaIzdavanja(), knjiga.getKratakOpis(),
				knjiga.getSlika(), knjiga.getCena(), knjiga.getBrojStranica(), knjiga.getTipPoveza().toString(), knjiga.getPismo().toString(), knjiga.getJezik(), knjiga.getId());
		// TODO Auto-generated method stub
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Knjiga> findByZanr(Zanr zanr) {
		// TODO Auto-generated method stub
		/*
		String sql = "SELECT * FROM knjiga_zanr WHERE Zanr_id = ?";
		return jdbcTemplate.query(sql, new KnjigaRowMapper(), zanr.getId());
		*/
		return null;
	}

	@Override
	public List<Knjiga> find(String naziv, Zanr zanr, double minCena, double maxCena, String autor, String jezik) {
		try {
			String sql = "SELECT * FROM knjiga WHERE naziv LIKE ? AND cena >= ? AND cena <= ? AND autor LIKE ? AND jezik LIKE ?";
			return jdbcTemplate.query(sql, new KnjigaRowMapper(), "%" +naziv +"%", minCena, maxCena, "%"+autor+"%", "%"+jezik+"%");
		} catch (EmptyResultDataAccessException ex) {
			// ako korisnik nije pronađen
			return null;
		}
	}

}
