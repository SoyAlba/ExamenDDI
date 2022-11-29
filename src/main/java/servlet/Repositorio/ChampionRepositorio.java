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

public class ChampionRepositorio {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/test;INIT=RUNSCRIPT FROM 'classpath:servlet/conexion/lolh2.sql'";
	AbstractConnection manager = new H2Connection();

	public void insert(Champion champion) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO champions (id,champion_name,title,lore,tags)" + "VALUES (?, ?, ?,?,?)");
			preparedStatement.setInt(1, champion.getId());
			preparedStatement.setString(2, champion.getName());
			preparedStatement.setString(3, champion.getTitle());
			preparedStatement.setString(4, champion.getLore());
			preparedStatement.setString(5, champion.getTags());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public void buscar(Champion champion) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO champions (id,champion_name,title,lore,tags)" + "VALUES (?, ?, ?,?,?)");
			preparedStatement.setInt(1, champion.getId());
			preparedStatement.setString(2, champion.getName());
			preparedStatement.setString(3, champion.getTitle());
			preparedStatement.setString(4, champion.getLore());
			preparedStatement.setString(5, champion.getTags());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}

	public List<Champion> listAll() {
		List<Champion> lista = new ArrayList<>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM champions ");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Champion champion = new Champion();
				champion.setId(resultSet.getInt("id"));
				champion.setName(resultSet.getString("champion_name"));
				champion.setTitle(resultSet.getString("title"));
				champion.setLore(resultSet.getString("lore"));
				champion.setTags(resultSet.getString("tags"));
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

		public void deleteById(int id){
	        Connection conn = manager.open(jdbcUrl);
	        PreparedStatement statement = null;
	        try{
	            statement = conn.prepareStatement("delete from champion where id = ?");
	            statement.setInt(1, id);
	            statement.executeUpdate();
	            manager.close(statement);
	            statement = conn.prepareStatement("delete from champion_abilities where id = ?");
	            statement.setInt(1, id);
	            statement.executeUpdate();
	        } catch (SQLException e){

	        } finally {
	            manager.close(statement);
	            manager.close(conn);
	        }
	}

	
}
