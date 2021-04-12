package it.objectmethod.dbexercise.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.dbexercise.config.ConnectionFactory;
import it.objectmethod.dbexercise.dao.ICitiesDao;
import it.objectmethod.dbexercise.domain.City;

public class CitiesDaoImpl implements ICitiesDao{

	@Override
	public List<City> GetCities(String countryCode) throws SQLException {
		City city = null;
		List<City> citiesList = new ArrayList<>();
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement(
		"SELECT * FROM city c WHERE CountryCode = ?");
		statement.setString(1, countryCode);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			city = new City();
			city.setName(resultSet.getString("Name"));
			city.setPopulation(resultSet.getInt("Population"));
			citiesList.add(city);
		}

		return citiesList;
	}

}
