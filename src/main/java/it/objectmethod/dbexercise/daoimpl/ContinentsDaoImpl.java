package it.objectmethod.dbexercise.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.dbexercise.config.ConnectionFactory;
import it.objectmethod.dbexercise.dao.IContinentsDao;
import it.objectmethod.dbexercise.domain.Continent;

public class ContinentsDaoImpl implements IContinentsDao {

	@Override
	public List<Continent> GetContinents() throws SQLException {
		Continent continent = null;
		List<Continent> listContinents = new ArrayList<>();
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement(
		"SELECT DISTINCT Continent FROM country c");
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			continent = new Continent();
			continent.setName(resultSet.getString("Continent"));
			listContinents.add(continent);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return listContinents;
	}

}
