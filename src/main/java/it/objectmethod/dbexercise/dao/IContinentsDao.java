package it.objectmethod.dbexercise.dao;

import java.sql.SQLException;
import java.util.List;

import it.objectmethod.dbexercise.domain.Continent;

public interface IContinentsDao {
	public List<Continent> GetContinents() throws SQLException;
}
