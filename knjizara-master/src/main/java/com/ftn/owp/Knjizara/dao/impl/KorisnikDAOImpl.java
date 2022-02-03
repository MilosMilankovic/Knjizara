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

import com.ftn.owp.Knjizara.dao.KorisnikDAO;
import com.ftn.owp.Knjizara.model.Korisnik;
import com.ftn.owp.Knjizara.model.Uloga;

@Repository
public class KorisnikDAOImpl implements KorisnikDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class KorisnikRowMapper implements RowMapper<Korisnik> {

		@Override
		public Korisnik mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt(1);
			String korisnickoIme = rs.getString(2);
			String lozinka = rs.getString(3);
			String email = rs.getString(4);
			String ime = rs.getString(5);
			String prezime = rs.getString(6);
			Date datumRodjenja = rs.getDate(7);
			String adresa = rs.getString(8);
			String brojTelefona = rs.getString(9);
			Date datumVremeRegistracije = rs.getDate(10);
			Uloga uloga = Uloga.valueOf(rs.getString(11));
			boolean blokiran = rs.getBoolean(12);

			Korisnik korisnik = new Korisnik(id, korisnickoIme, lozinka, email, ime, prezime, datumRodjenja, adresa, brojTelefona,
					datumVremeRegistracije, uloga, blokiran);
			return korisnik;
		}

	}
	
	@Override
	public Korisnik findOne(int id) {
		try {
			String sql = "SELECT * FROM korisnik WHERE id = ?";
			return jdbcTemplate.queryForObject(sql, new KorisnikRowMapper(), id);
		} catch (EmptyResultDataAccessException ex) {
			// ako korisnik nije pronađen
			return null;
		}
		
	}
	
	@Override
	public Korisnik findOne(String korisnickoIme) {
		try {
			String sql = "SELECT * FROM korisnik WHERE korisnickoIme = ?";
			return jdbcTemplate.queryForObject(sql, new KorisnikRowMapper(), korisnickoIme);
		} catch (EmptyResultDataAccessException ex) {
			// ako korisnik nije pronađen
			return null;
		}
	}
	@Override
	public Korisnik findOne(String korisnickoIme, String lozinka) {
		try {
			String sql = "SELECT * FROM mydb.korisnik WHERE korisnickoIme = ? AND lozinka = ?";
			return jdbcTemplate.queryForObject(sql, new KorisnikRowMapper(), korisnickoIme, lozinka);
		} catch (EmptyResultDataAccessException ex) {
			// ako korisnik nije pronađen
			return null;
		}
	}
	@Override
	public List<Korisnik> findAll() {
		String sql = "SELECT * FROM korisnik";
		return jdbcTemplate.query(sql, new KorisnikRowMapper());
	}
	@Override
	public List<Korisnik> find(String korisnickoIme, String eMail, String pol, Boolean administrator) {
		
		ArrayList<Object> listaArgumenata = new ArrayList<Object>();
		
		String sql = "SELECT korisnickoIme, eMail, pol, administrator FROM korisnici ";
		
		StringBuffer whereSql = new StringBuffer(" WHERE ");
		boolean imaArgumenata = false;
		
		if(korisnickoIme!=null) {
			korisnickoIme = "%" + korisnickoIme + "%";
			if(imaArgumenata)
				whereSql.append(" AND ");
			whereSql.append("korisnickoIme LIKE ?");
			imaArgumenata = true;
			listaArgumenata.add(korisnickoIme);
		}
		
		if(eMail!=null) {
			eMail = "%" + eMail + "%";
			if(imaArgumenata)
				whereSql.append(" AND ");
			whereSql.append("eMail LIKE ?");
			imaArgumenata = true;
			listaArgumenata.add(eMail);
		}
		
		if(pol!=null) {
			pol = "%" + pol + "%";
			if(imaArgumenata)
				whereSql.append(" AND ");
			whereSql.append("pol LIKE ?");
			imaArgumenata = true;
			listaArgumenata.add(pol);
		}
		
		if(administrator!=null) {	
			//vraća samo administratore ili sve korisnike sistema
			String administratorSql = (administrator)? "administrator = 1": "administrator >= 0";
			if(imaArgumenata)
				whereSql.append(" AND ");
			whereSql.append(administratorSql);
			imaArgumenata = true;
		}
		
		
		if(imaArgumenata)
			sql=sql + whereSql.toString()+" ORDER BY korisnickoIme";
		else
			sql=sql + " ORDER BY korisnickoIme";
		System.out.println(sql);
		
		return jdbcTemplate.query(sql, listaArgumenata.toArray(), new KorisnikRowMapper());
	}
	@Override
	public void save(Korisnik korisnik) {
		String sql = "INSERT INTO korisnik (korisnickoIme, lozinka, email, ime, prezime, datumRodjenja, adresa, brojTelefona, datumVremeRegistracije, uloga, blokiran) VALUES (?,?, ?,?, ?,?,?,?, NOW(), ?, ?)";
		jdbcTemplate.update(sql, korisnik.getKorisnickoIme(), korisnik.getLozinka(), korisnik.getEmail(),
				korisnik.getIme(), korisnik.getPrezime(), 
				korisnik.getDatumRodjenja(), korisnik.getAdresa(), korisnik.getBrojTelefona(), Uloga.KUPAC.toString(), korisnik.isBlokiran());
	}
	
	@Override
	public void update(Korisnik korisnik) {
		/*
		if (korisnik.getLozinka() == null) {
			String sql = "UPDATE korisnici SET eMail = ?, pol = ?, administrator = ? WHERE korisnickoIme = ?";
			jdbcTemplate.update(sql, korisnik.getEMail(), korisnik.getPol(), korisnik.isAdministrator(), korisnik.getKorisnickoIme());
		} else {
			String sql = "UPDATE korisnici SET lozinka = ?, eMail = ?, pol = ?, administrator = ? WHERE korisnickoIme = ?";
			jdbcTemplate.update(sql, korisnik.getLozinka(), korisnik.getEMail(), korisnik.getPol(), korisnik.isAdministrator(), korisnik.getKorisnickoIme());
		}
		*/
	}
	

	@Override
	public void delete(String korisnickoIme) {
		/*
		String sql = "DELETE FROM korisnici WHERE korisnickoIme = ?";
		jdbcTemplate.update(sql, korisnickoIme);
		*/
	}

	@Override
	public void promeniUlogu(Korisnik korisnik, Uloga uloga) {
		// TODO Auto-generated method stub
		String sql = "UPDATE korisnik SET uloga=? WHERE id=?";
		jdbcTemplate.update(sql, uloga.toString(), korisnik.getId());
		// TODO Auto-generated method stub
	}
	@Override
	public void promeniBlokStatus(Korisnik korisnik, boolean blokStatus) {
		String sql = "UPDATE korisnik SET blokiran=? WHERE id=?";
		jdbcTemplate.update(sql, blokStatus, korisnik.getId());
	}
	

}
