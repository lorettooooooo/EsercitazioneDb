package it.objectmethod.dbexercise.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.objectmethod.dbexercise.config.ConnectionFactory;
import it.objectmethod.dbexercise.dao.ICityDao;
import it.objectmethod.dbexercise.domain.City;

public class CityDaoImpl implements ICityDao {

	@Override
	public City getCityByName(String cityName) throws SQLException {
		City city = null;
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM city WHERE Name = ?");
		statement.setString(1, cityName);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			city = new City();
			city.setId(resultSet.getInt("ID"));
			city.setName(resultSet.getString("Name"));
			city.setCountryCode(resultSet.getString("CountryCode"));
			city.setDistrict(resultSet.getString("District"));
			city.setPopulation(resultSet.getInt("Population"));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return city;
	}

}
