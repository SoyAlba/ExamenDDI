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

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/test;";
	AbstractConnection manager = new H2Connection();

	

	public List<ChampionAbiliti> buscar(int uno,int dos) {
		List<ChampionAbiliti> lista = new ArrayList<>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ChampionAbiliti champion = new ChampionAbiliti();
		try {
			preparedStatement = conn
					.prepareStatement("select c.name,c.description, c.effect,c.cost,c.rango from champion_abilities as c where rango BETWEEN (?) and (?)");
			preparedStatement.setInt(1, uno);
			preparedStatement.setInt(2, dos);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				champion.setName(resultSet.getString(1));
				champion.setDescription(resultSet.getString(2));
				champion.setEffect(resultSet.getString(3));
				champion.setCost(resultSet.getInt(4));
				champion.setRange(resultSet.getInt(5));
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
