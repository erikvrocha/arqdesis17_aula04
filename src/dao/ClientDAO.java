package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Client;

public class ClientDAO {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}	
	
	// Obtendo conexão com banco de dados
	public Connection getConnection() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost/vendas?user=alunos&password=alunos");
	}
	
	public void create(Client client) {
		String sqlInsert = "INSERT INTO cliente(nome, fone, email) VALUES (?, ?, ?)";
		// usando o try catch
		try (Connection conn = getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, client.getName());
			stm.setString(2, client.getPhone());
			stm.setString(3, client.getEmail());
			stm.execute();
			String sqlQuery  = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					client.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Client client) {
		String sqlUpdate = "UPDATE cliente SET nome=?, fone=?, email=? WHERE id=?";
		// usando o try catch
		try (Connection conn = getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, client.getName());
			stm.setString(2, client.getPhone());
			stm.setString(3, client.getEmail());
			stm.setInt(	  4, client. getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Client client) {
		String sqlDelete = "DELETE FROM cliente WHERE id = ?";
		// usando o try catch
		try (Connection conn = getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, client.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Client load(int id) {
		Client client = new Client();
		client.setId(id);
		String sqlSelect = "SELECT nome, fone, email FROM cliente WHERE cliente.id = ?";
		// usando o try catch
		try (Connection conn = getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, client.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					client.setName(rs.getString("name"));
					client.setPhone(rs.getString("phone"));
					client.setEmail(rs.getString("email"));
				} else {
					client.setId(-1);
					client.setName(null);
					client.setPhone(null);
					client.setEmail(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return client;
	}
	
}
