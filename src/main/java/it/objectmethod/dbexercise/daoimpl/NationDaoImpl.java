package it.objectmethod.dbexercise.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.dbexercise.config.ConnectionFactory;
import it.objectmethod.dbexercise.dao.INationDao;
import it.objectmethod.dbexercise.domain.Nation;

public class NationDaoImpl implements INationDao {

	@Override
	public List<Nation> getNationListByName(String nationName, String continentName) throws SQLException {
		Nation nation = null;
		List<Nation> listNation = new ArrayList<>();
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement(
				"SELECT * FROM country c " + "WHERE (\"\" LIKE ? OR Name LIKE ?) AND (\"\" LIKE ? OR Continent LIKE ? )");
		statement.setString(1, nationName);
		statement.setString(2, nationName);
		statement.setString(3, continentName);
		statement.setString(4, continentName);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			nation = new Nation();
			nation.setCode(resultSet.getString("Code"));
			nation.setName(resultSet.getString("Name"));
			nation.setContinent(resultSet.getString("Continent"));
			nation.setPopulation(resultSet.getInt("Population"));
			nation.setArea(resultSet.getInt("SurfaceArea"));
			listNation.add(nation);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return listNation;
	}

}
