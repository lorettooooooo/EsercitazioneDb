package it.objectmethod.dbexercise.dao;

import java.sql.SQLException;
import java.util.List;

import it.objectmethod.dbexercise.domain.City;

public interface ICitiesDao {
	public List<City> GetCities(String countryCode) throws SQLException;
}
