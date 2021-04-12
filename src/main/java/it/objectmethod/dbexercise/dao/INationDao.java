package it.objectmethod.dbexercise.dao;

import java.sql.SQLException;
import java.util.List;

import it.objectmethod.dbexercise.domain.Nation;

public interface INationDao {

	public List<Nation> getNationListByName(String nationName, String continentName) throws SQLException;
}
