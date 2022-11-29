package servlet.Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import servlet.conexion.AbstractConnection;
import servlet.conexion.H2Connection;
import servlet.modelos.Champion;
import servlet.modelos.ChampionAbiliti;

public class AbilityRepositorio {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/test;INIT=RUNSCRIPT FROM 'classpath:servlet/conexion/lolh2.sql'";
	AbstractConnection manager = new H2Connection();

	

	public List<ChampionAbiliti> buscar() {
		List<ChampionAbiliti> lista = new ArrayList<>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ChampionAbiliti champion = new ChampionAbiliti();
		try {
			preparedStatement = conn
					.prepareStatement("select * from champion_abilities (id,name,description,effect,cost,range)" + "VALUES (?, ?, ?,?,?,?)");
			preparedStatement.setInt(1, champion.getId());
			preparedStatement.setString(2, champion.getName());
			preparedStatement.setString(3, champion.getDescription());
			preparedStatement.setString(4, champion.getEffect());
			preparedStatement.setInt(5, champion.getCost());
			preparedStatement.setInt(6, champion.getRange());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				champion.setName(resultSet.getString("name"));
				champion.setDescription(resultSet.getString("description"));;
				champion.setEffect(resultSet.getString("effect"));;
				champion.setCost(resultSet.getInt("cost"));;
				champion.setRange(resultSet.getInt("range"));;
				lista.add(champion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return lista;
	}

	public void deleteWhereName(String item) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("DELETE FROM champion_abilities WHERE name = ?");
			preparedStatement.setString(1, item);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	
}