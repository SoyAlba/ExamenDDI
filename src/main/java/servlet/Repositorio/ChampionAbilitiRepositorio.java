package servlet.Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servlet.conexion.AbstractConnection;
import servlet.conexion.H2Connection;
import servlet.modelos.ChampionAbiliti;

public class ChampionAbilitiRepositorio {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/test;INIT=RUNSCRIPT FROM 'classpath:servlet/conexion/lolh2.sql',RUNSCRIPT FROM 'classpath:servlet/conexion/lolh2initdata.sql'";
	AbstractConnection manager = new H2Connection();

	public void insert(ChampionAbiliti abiliti) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO champion_abilities (id,champion,name,description,effect,cost,range)" + "VALUES (?, ?, ?, ?,?,?,?)");
			preparedStatement.setInt(1, abiliti.getId());
			preparedStatement.setString(2, abiliti.getChampion());
			preparedStatement.setString(3, abiliti.getName());
			preparedStatement.setString(4, abiliti.getDescription());
			preparedStatement.setString(5, abiliti.getEffect());
			preparedStatement.setFloat(6, abiliti.getCost());
			preparedStatement.setInt(7, abiliti.getRange());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}

	public List<ChampionAbiliti> listAll() {
		List<ChampionAbiliti> lista = new ArrayList<>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM champion_abilities ");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ChampionAbiliti abiliti = new ChampionAbiliti();
				abiliti.setId(resultSet.getInt("id"));
				abiliti.setChampion(resultSet.getString("champion"));
				abiliti.setName(resultSet.getString("name"));
				abiliti.setDescription(resultSet.getString("description"));
				abiliti.setEffect(resultSet.getString("effect"));
				abiliti.setCost(resultSet.getInt("cost"));
				abiliti.setRange(resultSet.getInt("range"));
				lista.add(abiliti);
			
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
