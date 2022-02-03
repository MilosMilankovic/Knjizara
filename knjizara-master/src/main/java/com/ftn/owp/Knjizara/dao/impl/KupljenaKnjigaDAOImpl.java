package com.ftn.owp.Knjizara.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ftn.owp.Knjizara.dao.KnjigaDAO;
import com.ftn.owp.Knjizara.dao.KupljenaKnjigaDAO;
import com.ftn.owp.Knjizara.model.Knjiga;
import com.ftn.owp.Knjizara.model.KupljenaKnjiga;
import com.ftn.owp.Knjizara.model.Zanr;

@Repository
public class KupljenaKnjigaDAOImpl implements KupljenaKnjigaDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired KnjigaDAO knjigaDAO;
	private class KupljenaKnjigaRowMapper implements RowMapper<KupljenaKnjiga> {

		@Override
		public KupljenaKnjiga mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt(1);
			int idKnjiga = rs.getInt(2);
			Knjiga knjiga = knjigaDAO.findOne(idKnjiga);
			
			int brojPrimeraka = rs.getInt(3);
			double cena = rs.getDouble(4);
			
			KupljenaKnjiga kupljenaKnjiga = new KupljenaKnjiga(id, knjiga, brojPrimeraka, cena);
			return kupljenaKnjiga;

			
		}

	}


	@Override
	public KupljenaKnjiga findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KupljenaKnjiga> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KupljenaKnjiga> find(String naziv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(KupljenaKnjiga kupljenaKnjiga) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO kupljenaknjiga ( brojPrimeraka, Knjiga_id, cena) VALUES (?,?, ?)";
		jdbcTemplate.update(sql, kupljenaKnjiga.getBrojPrimeraka(), kupljenaKnjiga.getKnjiga().getId(), kupljenaKnjiga.getCena());
	}

	@Override
	public int[] save(ArrayList<KupljenaKnjiga> kupljeneKnjige) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(KupljenaKnjiga kupljenaKnjiga) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
