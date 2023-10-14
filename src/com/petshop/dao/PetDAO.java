package com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.petshop.model.Cliente;
import com.petshop.model.Pet;

public class PetDAO {

	private static String sql;

	private final Connection connection;

	public PetDAO(Connection connection) {

		this.connection = connection;

	}

	// CREATE
	public void createPet(Pet pet) {
		sql = "INSERT INTO Pet (nomePet,portePet,especiePet,racaPet,idadePet,idCliente) VALUES (?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, pet.getNomePet());
			stmt.setString(2, pet.getPortePet());
			stmt.setString(3, pet.getEspeciePet());
			stmt.setString(4, pet.getRacaPet());
			stmt.setInt(5, pet.getIdadePet());
			stmt.setInt(6, pet.getCliente().getIdCliente());

			stmt.executeUpdate();
			System.out.println("Pet criado com sucesso! " + pet.toString());
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
		}

	}

	// READ
	public void readAllPets() {
		sql = "SELECT * FROM pet as p " + "INNER JOIN cliente as c " + "ON p.idCliente = c.idCliente";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Pet pet = new Pet();
				Cliente cliente = new Cliente();
				pet.setNomePet(r.getString("nomePet"));
				pet.setPortePet(r.getString("portePet"));
				pet.setEspeciePet(r.getString("especiePet"));
				pet.setRacaPet(r.getString("racaPet"));
				pet.setIdadePet(r.getInt("idadePet"));
				cliente.setIdCliente(r.getInt("idCliente"));
				cliente.setNomeCliente(r.getString("nomeCliente"));

				System.out
						.println("Nome do Pet: " + pet.getNomePet() + "\nNome do Cliente: " + cliente.getNomeCliente());

			}
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
		}
	}

	// UPDATE
	public void updatePet(Pet pet) {

		sql = "UPDATE pet SET nomePet = ?, portePet = ?, especiePet = ?, racaPet = ?, idadePet = ?, idCliente = ? WHERE idPet = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, pet.getNomePet());
			stmt.setString(2, pet.getPortePet());
			stmt.setString(3, pet.getEspeciePet());
			stmt.setString(4, pet.getRacaPet());
			stmt.setInt(5, pet.getIdadePet());
			stmt.setInt(6, pet.getCliente().getIdCliente());
			stmt.setInt(7, pet.getIdPet());

			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
			System.out.println("Nao foi possivel atualizar o Pet");
		}
	}

	// DELETE
	public void deletePet(int id) {
		sql = "DELETE FROM pet WHERE idPet = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
		}
	}

}
