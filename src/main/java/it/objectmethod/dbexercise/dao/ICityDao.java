package it.objectmethod.dbexercise.dao;

import java.sql.SQLException;

import it.objectmethod.dbexercise.domain.City;

public interface ICityDao {

	public City getCityByName(String cityName) throws SQLException ;

}