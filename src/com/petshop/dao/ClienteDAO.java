package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.petshop.model.Cliente;

public class ClienteDAO {

	private static String sql;

	private final Connection connection;

	public ClienteDAO(Connection connection) {

		this.connection = connection;

	}

	// CREATE
	public void createClient(Cliente cliente) {
		sql = "INSERT INTO cliente (nomeCliente,cpfCliente,enderecoCliente,telefone) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getCpfCliente());
			stmt.setString(3, cliente.getEnderecoCliente());
			stmt.setString(4, cliente.getTelefone());

			stmt.executeUpdate();
			System.out.println("Cliente criado com sucesso! " + cliente.toString());
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
		}

	}

	// READ
	public void readAllClients() {
		sql = "SELECT * FROM cliente";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Cliente cliente = new Cliente();
				cliente.setNomeCliente(r.getString("nomeCliente"));
				cliente.setCpfCliente(r.getString("cpfCliente"));
				cliente.setEnderecoCliente(r.getString("enderecoCliente"));
				cliente.setTelefone(r.getString("telefone"));

				System.out.printf("Nome: %s\nCPF: %s\nEndereco: %s\n  \n", cliente.getNomeCliente(),
						cliente.getCpfCliente(), cliente.getEnderecoCliente(), cliente.getTelefone());

			}
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
		}
	}
	
	
	//UPDATE
	public void updateCliente(Cliente cliente) {
		
		sql = "UPDATE cliente SET nomeCliente = ?, cpfCliente = ?, enderecoCliente = ?, telefone = ? WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getCpfCliente());
			stmt.setString(3, cliente.getEnderecoCliente());
			stmt.setString(4, cliente.getTelefone());
			stmt.setInt(5, cliente.getIdCliente());
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.printf(e.getMessage());
		}
	}
	
	
	

	// DELETE
	public void deleteClient(int id) {
		sql = "DELETE FROM cliente WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
		}
	}

}
